package com.microservice.placeholder.controller;

import com.microservice.placeholder.service.UserServiceImpl;
import com.microservice.placeholder.service.dto.Post;
import com.microservice.placeholder.service.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uvaq/api")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Long id) {
        return userService.findPostsByUserId(id);
    }
}
