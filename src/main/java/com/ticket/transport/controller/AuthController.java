package com.ticket.transport.controller;

import com.ticket.transport.common.EndpointConstant;
import com.ticket.transport.common.Role;
import com.ticket.transport.config.security.JwtTokenUtil;
import com.ticket.transport.config.security.UserDetailsImpl;
import com.ticket.transport.mapper.LoginMapper;
import com.ticket.transport.model.entity.Account;
import com.ticket.transport.model.request.LoginRequest;
import com.ticket.transport.model.request.RefreshTokenRequest;
import com.ticket.transport.model.response.LoginResponse;
import com.ticket.transport.model.response.RefreshTokeResponse;
import com.ticket.transport.service.AccountService;
import com.ticket.transport.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authManager;
    private final AccountService accountService;
    private final LoginMapper loginMapper;
    private final CompanyService companyService;

    @PostMapping(path = EndpointConstant.Authentication.LOGIN_ENDPOINT)
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication authentication = authManager.authenticate(authenticationToken);
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenUtil.generateToken(authentication);
            String refreshToken = jwtTokenUtil.generateRefreshToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            String role = userDetails.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining());

            LoginResponse response = loginMapper.mapUserDetailsImplToLoginResponse(userDetails);
            response.setRoleName(role);

            Account account = null;

            if ((Role.COMPANY.name()).equals(role)) {
                account = companyService.findById(response.getId()).getAccount();
            }

            response.setToken(jwt);
            response.setRefreshToken(refreshToken);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(path = EndpointConstant.Authentication.REFRESH_TOKEN_ENDPOINT)
    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenRequest tokenRequest) {
        if (!jwtTokenUtil.validateToken(tokenRequest.getRefreshToken())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
        }
        String username = jwtTokenUtil.getUsernameFromJwt(tokenRequest.getRefreshToken());
        Account account = accountService.getAccountByUsername(username);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Token claim is invalid");
        }
        String newToken = jwtTokenUtil.generateToken(account.getUsername());
        String newRefreshToken = jwtTokenUtil.generateRefreshToken(account.getUsername());
        RefreshTokeResponse response = new RefreshTokeResponse(newToken, newRefreshToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
