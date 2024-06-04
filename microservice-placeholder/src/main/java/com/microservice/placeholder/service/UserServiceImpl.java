package com.microservice.placeholder.service;

import com.microservice.placeholder.exceptionhandler.PostsNotFoundException;
import com.microservice.placeholder.exceptionhandler.UserNotFoundException;
import com.microservice.placeholder.service.dto.Post;
import com.microservice.placeholder.service.dto.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl extends AbstractClient implements UserService {

    public UserServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public List<User> findAll() {
        String uri = jsonPlaceHolderBaseUrl + "/users";
        HttpEntity<Void> requestEntity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<User[]> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity, User[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(Objects.requireNonNull(response.getBody()));
        }

        throw new RuntimeException("Failed to fetch users: " + response.getStatusCode());
    }

    @Override
    public User findById(Long id) {
        String uri = jsonPlaceHolderBaseUrl + "/users/" + id;
        HttpEntity<Void> requestEntity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<User> response;

        try {
            response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, User.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new RuntimeException("Failed to fetch user: " + response.getStatusCode());
    }
    @Override
    public List<Post> findPostsByUserId(Long userId) {
        String uri = jsonPlaceHolderBaseUrl + "/users/" + userId + "/posts";
        HttpEntity<Void> requestEntity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Post[]> response;

        try {
            response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Post[].class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new PostsNotFoundException("Posts for user with ID " + userId + " not found");
        }

        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(Objects.requireNonNull(response.getBody()));
        }

        throw new RuntimeException("Failed to fetch posts for user: " + response.getStatusCode());
    }
}
