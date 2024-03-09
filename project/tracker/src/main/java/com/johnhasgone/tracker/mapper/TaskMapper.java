package com.johnhasgone.tracker.mapper;

import com.johnhasgone.tracker.dto.TaskDto;
import com.johnhasgone.tracker.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskMapper implements Mapper<Task, TaskDto> {

    private final AccountMapper accountMapper;

    @Override
    public Task toEntity(TaskDto dto) {
        var entity = new Task();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setAssignee(accountMapper.toEntity(dto.getAssignee()));
        return entity;
    }

    @Override
    public TaskDto toDto(Task entity) {
        var dto = new TaskDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setAssignee(accountMapper.toDto(entity.getAssignee()));
        return dto;
    }
}
