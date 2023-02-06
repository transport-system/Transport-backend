package com.ticket.transport.controller;

import com.ticket.transport.model.response.AccountResponse;
import com.ticket.transport.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<List<AccountResponse>> getAllAccount() {
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable("id") Long id) {
        return new ResponseEntity<AccountResponse>(accountService.getAccountById(id), HttpStatus.valueOf(200));
    }
}
