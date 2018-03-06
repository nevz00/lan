package ru.sarrz.lan.service;

import ru.sarrz.lan.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    void update(User user);

    List<User> getAll();
}
