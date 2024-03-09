package com.johnhasgone.tracker.entity;

import com.johnhasgone.tracker.domain.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Role role;
}
