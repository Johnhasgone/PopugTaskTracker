package com.johnhasgone.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.johnhasgone.auth.domain.Role;
import com.johnhasgone.auth.dto.AccountDto;
import com.johnhasgone.auth.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountDto registerAccount(@RequestBody AccountDto dto) throws JsonProcessingException {
        return accountService.registerAccount(dto);
    }

    @PutMapping("/{id}")
    public AccountDto changeRole(@PathVariable UUID id, @RequestParam Role role) throws JsonProcessingException {
        return accountService.changeRole(id, role);
    }
}
