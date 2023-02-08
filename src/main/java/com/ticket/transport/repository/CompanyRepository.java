package com.ticket.transport.repository;

import com.ticket.transport.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByAccountId(Long id);
}
