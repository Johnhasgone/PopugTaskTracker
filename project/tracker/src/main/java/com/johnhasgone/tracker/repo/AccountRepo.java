package com.johnhasgone.tracker.repo;

import com.johnhasgone.tracker.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepo extends JpaRepository<Account, UUID> {
}
