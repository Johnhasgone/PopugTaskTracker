package com.johnhasgone.tracker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.johnhasgone.tracker.dto.TaskDto;
import com.johnhasgone.tracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public TaskDto createTask(TaskDto dto) throws JsonProcessingException {
        return taskService.createTask(dto);
    }

    @PutMapping("/shuffle")
    public void shuffleTasks() {
        taskService.shuffleTasks();
    }

    @PutMapping("/{id}")
    public TaskDto completeTask(@PathVariable UUID id) throws JsonProcessingException {
        return taskService.completeTask(id);
    }
}
