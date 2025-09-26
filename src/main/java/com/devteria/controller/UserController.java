package com.devteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.dto.request.UserCreationRequest;
import com.devteria.dto.request.UserUpdateRequest;
import com.devteria.identify_service.entity.User;
import com.devteria.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    User createUser (@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("")
    List<User> getUsers () {
        return userService.getUsers(); 
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    } 

    @PutMapping ("/{userId}") 
    User updateUser (@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser (@PathVariable String userId) {
        userService.deleteUser(userId);
        return "deleted user";
    }
}
