package com.devteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteria.dto.request.UserCreationRequest;
import com.devteria.dto.request.UserUpdateRequest;
import com.devteria.identify_service.entity.User;
import com.devteria.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userReponsitory;

    public User createUser (UserCreationRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userReponsitory.save(user);
    }

    public List<User>getUsers() {
        return userReponsitory.findAll();
    }

    public User getUser (String id) {
        return userReponsitory.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser (String userId, UserUpdateRequest request) {
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userReponsitory.save(user);
    }

    public void deleteUser (String userId) {
        userReponsitory.deleteById(userId);
    }
}
