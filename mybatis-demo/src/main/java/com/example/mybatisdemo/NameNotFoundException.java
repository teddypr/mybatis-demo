package com.example.mybatisdemo;

public class NameNotFoundException extends RuntimeException { //RuntimeException は非検査例外

    public NameNotFoundException(String message) {
        super(message);
    }
}
