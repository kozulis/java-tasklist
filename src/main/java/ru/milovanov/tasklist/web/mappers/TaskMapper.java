package ru.milovanov.tasklist.web.mappers;

import org.mapstruct.Mapper;
import ru.milovanov.tasklist.domain.task.Task;
import ru.milovanov.tasklist.web.dto.task.TaskDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    Task toEntity(TaskDto taskDto);

}
