package com.ticket.transport.config.security;

import com.ticket.transport.common.Status;
import com.ticket.transport.exception.UnauthorizedException;
import com.ticket.transport.model.entity.Account;
import com.ticket.transport.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.getAccountByUsername(username);
        if (account != null && !account.getActive().equals(Status.Account.INACTIVE.name())) {
            return UserDetailsImpl.build(account);
        } else if (account.getActive().equals(Status.Account.INACTIVE.name())) {
            throw new UnauthorizedException("Your account is currently inactive.");
        } else {
            throw new UnauthorizedException("Username " + username + " not found ");
        }
    }
}
