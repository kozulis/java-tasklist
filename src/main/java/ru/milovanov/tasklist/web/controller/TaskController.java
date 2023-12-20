package ru.milovanov.tasklist.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.milovanov.tasklist.domain.task.Task;
import ru.milovanov.tasklist.service.TaskService;
import ru.milovanov.tasklist.web.dto.task.TaskDto;
import ru.milovanov.tasklist.web.dto.validation.OnUpdate;
import ru.milovanov.tasklist.web.mappers.TaskMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
@Validated
@Tag(name = "Task Controller", description = "Task API")
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @PutMapping
    @Operation(summary = "Updste task")
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get taskDto by id")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete task")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }

}
