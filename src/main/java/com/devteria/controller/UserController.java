package com.devteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.dto.request.UserCreationRequest;
import com.devteria.identify_service.entity.User;
import com.devteria.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser (@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
}
