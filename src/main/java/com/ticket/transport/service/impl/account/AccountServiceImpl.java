package com.ticket.transport.service.impl.account;

import com.ticket.transport.model.entity.Account;
import com.ticket.transport.repository.AccountRepository;
import com.ticket.transport.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

//    @Override
//    public List<AccountResponse> getAllAccount() {
//        List<Account> accounts = accountRepository.findAll();
//
//        return accounts.stream()
//                .map(account -> modelMapper.map(account, AccountResponse.class))
//                .collect(Collectors.toList());
//    }
}
