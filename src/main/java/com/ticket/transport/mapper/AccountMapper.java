package com.ticket.transport.mapper;

import com.ticket.transport.model.entity.Account;
import com.ticket.transport.model.entity.Company;
import com.ticket.transport.model.response.AccountResponse;
import com.ticket.transport.model.response.CompanyResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        config = ConfigurationMapper.class)
public interface  AccountMapper {
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    AccountResponse mapAccountToAccountResponse(Account account);

    @InheritConfiguration(name = "mapAccountToAccountResponse")
    List<AccountResponse> mapAccountListToAccountResponseList(List<Account> account);

    //company
    @Mapping(target = "account", expression = "java(accountResponse)")
    CompanyResponse mapCompanyToCompanyResponse(Company company, AccountResponse accountResponse);
}
