package com.nhp.Identity.service;

import com.nhp.Identity.dto.request.UserCreationRequest;
import com.nhp.Identity.dto.request.UserUpdateRequest;
import com.nhp.Identity.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(UserCreationRequest request);
    public User updateUser(Long userId, UserUpdateRequest request);
    public void deleteUser(Long userId);
    public List<User> getUsers();
    public User getUser(Long id);
}
