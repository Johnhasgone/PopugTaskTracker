package com.johnhasgone.auth.entity;

import com.johnhasgone.auth.domain.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    @Enumerated
    private Role role;
}
