package com.ticket.transport.repository;

import com.ticket.transport.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByUsername(String username);

    Account findByUsername(String username);
}
