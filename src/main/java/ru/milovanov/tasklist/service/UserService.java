package ru.milovanov.tasklist.service;

import ru.milovanov.tasklist.domain.user.User;

public interface UserService {

    User getById(Long id);

    User getByUsername(String username);

    User update(User user);

    User create(User user);

    boolean isTaskUser(Long userId, Long taskId);

    void delete(Long id);

}
