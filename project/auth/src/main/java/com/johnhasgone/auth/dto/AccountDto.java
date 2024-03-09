package com.johnhasgone.auth.dto;

import com.johnhasgone.auth.domain.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class AccountDto {
    private UUID id;
    private String name;
    private Role role;
}
