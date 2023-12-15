package ru.milovanov.tasklist.repository;

import ru.milovanov.tasklist.domain.task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(Long id);

    List<Task> findAllByUsername(Long userId);

    void assignToUserById(Long taskId, Long userId);

    void updete(Task task);

    void create(Task task);

    void delete(Long id);

}
