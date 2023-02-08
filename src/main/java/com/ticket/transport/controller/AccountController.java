package com.ticket.transport.controller;

import com.ticket.transport.common.EndpointConstant;
import com.ticket.transport.config.security.JwtTokenUtil;
import com.ticket.transport.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = EndpointConstant.Account.ACCOUNT_ENDPOINT)

public class AccountController {
    private final AccountService accountService;
    private final JwtTokenUtil jwtTokenUtil;
}
