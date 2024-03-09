package com.johnhasgone.tracker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.johnhasgone.tracker.domain.Status;
import com.johnhasgone.tracker.dto.TaskDto;
import com.johnhasgone.tracker.entity.Account;
import com.johnhasgone.tracker.mapper.TaskMapper;
import com.johnhasgone.tracker.repo.AccountRepo;
import com.johnhasgone.tracker.repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepo taskRepo;
    private final AccountRepo accountRepo;
    private final TaskProducer taskProducer;
    private final Random random = new Random();

    public List<TaskDto> getTasks() {
        return taskRepo.findAll().stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    public TaskDto createTask(TaskDto dto) throws JsonProcessingException {
        var task = taskMapper.toEntity(dto);
        var accounts = accountRepo.findAll();
        var assignee = getRandomAccount(accounts);
        task.setAssignee(assignee);
        dto = taskMapper.toDto(taskRepo.save(task));

        taskProducer.sendTaskCreated(dto);
        return dto;
    }

    public void shuffleTasks() {
        var accounts = accountRepo.findAll();
        var tasks = taskRepo.findAll();

        tasks.forEach(task -> task.setAssignee(getRandomAccount(accounts)));
        tasks = taskRepo.saveAll(tasks);

        tasks.forEach(task -> taskProducer.sendTaskAssigned(taskMapper.toDto(task)));
    }

    private Account getRandomAccount(List<Account> accounts) {
        return accounts.get(random.nextInt(accounts.size()));
    }

    public TaskDto completeTask(UUID taskId) throws JsonProcessingException {
        var task = taskRepo.findById(taskId).orElseThrow();
        task.setStatus(Status.DONE);
        var taskDto = taskMapper.toDto(taskRepo.save(task));

        taskProducer.sendTaskCompleted(taskDto);

        return taskDto;
    }
}
