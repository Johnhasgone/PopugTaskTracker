package com.johnhasgone.tracker.entity;

import com.johnhasgone.tracker.domain.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;
    @Enumerated
    private Status status;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account assignee;
}
