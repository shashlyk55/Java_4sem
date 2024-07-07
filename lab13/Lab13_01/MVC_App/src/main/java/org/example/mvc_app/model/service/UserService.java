package org.example.mvc_app.model.service;

import org.example.mvc_app.model.dao.UserRepository;
import org.example.mvc_app.model.entity.User;

public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public boolean register(User user) {
        //if (userRepository.findByUsername(user.getUsername()) == null) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            return userRepository.save(user);
        }
        return false;
    }
}