package org.example.mvc_app.model.dao;

import org.example.mvc_app.model.entity.User;

public interface IUserRepository {
    User findByUsername(String username);
    boolean save(User user);
}
