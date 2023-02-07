package com.ticket.transport.service.impl.account;

import com.ticket.transport.exception.NotFoundException;
import com.ticket.transport.model.entity.Company;
import com.ticket.transport.repository.CompanyRepository;
import com.ticket.transport.service.CompanyService;
import com.ticket.transport.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Company> findAll() {
        return null;
    }

    @Override
    public Company findById(Long id) {
        return null;
    }

    @Override
    public void save(Company entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Company entity) {

    }

    @Override
    public List<Company> findByAccountId(Long accountId) {
        List<Company> companies = companyRepository.findByAccountId(accountId);

        if (companies == null || companies.isEmpty()) {
            throw new NotFoundException("ID not found");
        }
        return companies;
    }
}
