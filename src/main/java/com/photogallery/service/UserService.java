package com.photogallery.service;

import com.photogallery.model.User;

import java.util.List;

public interface UserService {
    public abstract List<User> getAllUsers();
    public abstract User getUserByUsername(String username);
}
