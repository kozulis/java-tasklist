package ru.milovanov.tasklist.repository.impl;

import org.springframework.stereotype.Repository;
import ru.milovanov.tasklist.domain.task.Task;
import ru.milovanov.tasklist.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUsername(Long userId) {
        return null;
    }

    @Override
    public void assignToUserById(Long taskId, Long userId) {

    }

    @Override
    public void updete(Task task) {

    }

    @Override
    public void create(Task task) {

    }

    @Override
    public void delete(Long taskId) {

    }

}
