package com.microservice.placeholder.exceptionhandler;

public class PostsNotFoundException extends RuntimeException {
    public PostsNotFoundException(String message) {
        super(message);
    }
}
