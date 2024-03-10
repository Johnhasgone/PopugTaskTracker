package com.johnhasgone.tracker.dto;

import com.johnhasgone.tracker.domain.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class AccountDto {
    private UUID id;
    private String name;
    private Role role;
}
