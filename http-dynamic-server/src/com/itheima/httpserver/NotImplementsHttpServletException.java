package com.itheima.httpserver;

public class NotImplementsHttpServletException extends RuntimeException{

    public NotImplementsHttpServletException() {
    }

    public NotImplementsHttpServletException(String message) {
        super(message);
    }
}
