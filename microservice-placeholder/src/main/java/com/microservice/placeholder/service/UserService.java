package com.microservice.placeholder.service;

import com.microservice.placeholder.service.dto.Post;
import com.microservice.placeholder.service.dto.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    List<Post> findPostsByUserId(Long userId);
}
