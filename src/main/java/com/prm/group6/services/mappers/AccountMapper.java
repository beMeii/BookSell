package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.AccountDTO;
import com.prm.group6.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Mapper
@Validated
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Valid AccountDTO accountToAccountDto(@Valid Account account);
    @Valid Account accountDtoToAccount(@Valid AccountDTO accountDTO);
}
