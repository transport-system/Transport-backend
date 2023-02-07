package com.ticket.transport.service;

import com.ticket.transport.model.entity.Company;

import java.util.List;

public interface CompanyService extends CRUDService<Company> {
    List<Company> findByAccountId(Long id);
}
