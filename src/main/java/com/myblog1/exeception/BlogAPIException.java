package com.myblog1.exeception;


import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
