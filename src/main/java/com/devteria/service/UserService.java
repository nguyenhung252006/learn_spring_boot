package com.devteria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devteria.dto.request.UserCreationRequest;
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
}
