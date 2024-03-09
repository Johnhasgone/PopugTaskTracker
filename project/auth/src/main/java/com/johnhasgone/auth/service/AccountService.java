package com.johnhasgone.auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.johnhasgone.auth.domain.Role;
import com.johnhasgone.auth.dto.AccountDto;
import com.johnhasgone.auth.mapper.AccountMapper;
import com.johnhasgone.auth.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepo accountRepo;
    private final AccountProducer accountProducer;


    public AccountDto registerAccount(AccountDto dto) throws JsonProcessingException {
        dto = accountMapper.toDto(accountRepo.save(accountMapper.toEntity(dto)));
        accountProducer.sendCud(dto);
        return dto;
    }

    public AccountDto changeRole(UUID id, Role role) throws JsonProcessingException {
        var account = accountRepo.findById(id).orElseThrow();
        account.setRole(role);
        var dto = accountMapper.toDto(accountRepo.save(account));
        accountProducer.sendBe(dto);
        return dto;
    }
}
