package com.johnhasgone.tracker.repo;

import com.johnhasgone.tracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {
}
