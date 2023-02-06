package com.ticket.transport.service;


import com.ticket.transport.model.request.AccountRequest;
import com.ticket.transport.model.response.AccountResponse;

import java.util.List;

public interface AccountService {
    List<AccountResponse> getAllAccount();
    AccountResponse getAccountById(Long id);

//    Integer editSetting(AccountRequest accountRequest);
}
