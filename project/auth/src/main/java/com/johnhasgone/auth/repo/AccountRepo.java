package com.johnhasgone.auth.repo;

import com.johnhasgone.auth.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepo extends JpaRepository<Account, UUID> {
}
