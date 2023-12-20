package ru.milovanov.tasklist.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.milovanov.tasklist.domain.task.Status;
import ru.milovanov.tasklist.web.dto.validation.OnCreate;
import ru.milovanov.tasklist.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;

@Data
@Schema(description = "Task DTO")
public class TaskDto {

    @Schema(description = "Task id", example = "2")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "Task title", example = "Do homework")
    @NotNull(message = "Title must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title must be less than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Schema(description = "Task description", example = "Math, Physics, Literature")
    @Length(max = 255, message = "Discription must be less than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    @Schema(description = "Task status", example = "IN_PROGRESS")
    private Status status;

    @Schema(description = "Task expiration date", example = "2023-01-31 00:00:00")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;

}
