package com.johnhasgone.tracker.dto;

import com.johnhasgone.tracker.domain.Status;
import com.johnhasgone.tracker.entity.Account;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
public class TaskDto {
    private UUID id;
    private String description;
    private Status status;
    @ManyToOne
    private AccountDto assignee;
}
