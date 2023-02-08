package com.ticket.transport.service;


import com.ticket.transport.model.entity.Account;
import com.ticket.transport.model.request.AccountRequest;
import com.ticket.transport.model.response.AccountResponse;

import java.util.List;

public interface AccountService {
    Account getAccountByUsername(String username);
}
