package ru.milovanov.tasklist.service.impl;

import org.springframework.stereotype.Service;
import ru.milovanov.tasklist.domain.user.User;
import ru.milovanov.tasklist.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public boolean isTaskUser(Long userId, Long taskId) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

}