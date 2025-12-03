package com.photogallery.service;

import com.photogallery.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserService {
    public abstract List<User> getAllUsers();
    public abstract User getUserByUsername(String username);
    public abstract void saveUser(User user, PasswordEncoder passwordEncoder);
}
