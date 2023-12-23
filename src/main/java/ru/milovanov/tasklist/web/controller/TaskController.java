package ru.milovanov.tasklist.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.milovanov.tasklist.domain.task.Task;
import ru.milovanov.tasklist.service.TaskService;
import ru.milovanov.tasklist.utils.OpenApiResponses;
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
    @OpenApiResponses(summary = "Updste task", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = TaskDto.class)))
    @PreAuthorize("canAccessTask(#dto.id)")
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @GetMapping("/{id}")
    @OpenApiResponses(summary = "Get taskDto by id", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = TaskDto.class)))
    @Parameter(name = "id", description = "Task id", example = "1")
    @PreAuthorize("canAccessTask(#id)")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete task", parameters = {@Parameter(name = "id", description = "Task id", example = "1")})
    @PreAuthorize("canAccessTask(#id)")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }

}
