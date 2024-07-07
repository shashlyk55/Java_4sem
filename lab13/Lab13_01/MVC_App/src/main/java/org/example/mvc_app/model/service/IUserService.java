package org.example.mvc_app.model.service;

import org.example.mvc_app.model.entity.User;

public interface IUserService {
    boolean authenticate(String username, String password);
    boolean register(User user);
}