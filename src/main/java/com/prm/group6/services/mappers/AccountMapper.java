package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO accountToAccountDto(Account account);
    Account accountDtoToAccount(AccountDTO accountDTO);
}
