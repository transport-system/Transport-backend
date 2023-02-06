package com.ticket.transport.service.impl;

import com.ticket.transport.model.entity.Account;
import com.ticket.transport.model.request.AccountRequest;
import com.ticket.transport.model.response.AccountResponse;
import com.ticket.transport.repository.AccountRepository;
import com.ticket.transport.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<AccountResponse> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream()
                .map(account -> modelMapper.map(account, AccountResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse getAccountById(Long id) {
        Account account = accountRepository.findById(id).get();
        AccountResponse accountResponse = modelMapper.map(account, AccountResponse.class);
        return accountResponse;
    }

//    @Override
//    public Integer editSetting(AccountRequest accountRequest) {
//        Long id = accountRequest.getId();
//
//    }
}
