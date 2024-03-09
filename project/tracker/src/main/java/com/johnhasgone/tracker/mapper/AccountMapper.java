package com.johnhasgone.tracker.mapper;

import com.johnhasgone.tracker.dto.AccountDto;
import com.johnhasgone.tracker.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper implements Mapper<Account, AccountDto> {
    @Override
    public Account toEntity(AccountDto dto) {
        var entity = new Account();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        return entity;
    }

    @Override
    public AccountDto toDto(Account entity) {
        var dto = new AccountDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRole(entity.getRole());
        return dto;
    }
}
