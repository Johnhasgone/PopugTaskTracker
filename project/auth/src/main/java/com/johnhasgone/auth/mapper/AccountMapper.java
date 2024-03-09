package com.johnhasgone.auth.mapper;

import com.johnhasgone.auth.dto.AccountDto;
import com.johnhasgone.auth.entity.Account;
import com.johnhasgone.auth.repo.AccountRepo;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDto toDto(Account entity) {
        var dto = new AccountDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRole(entity.getRole());
        return dto;
    }

    public Account toEntity(AccountDto dto) {
        var entity = new Account();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        return entity;
    }
}
