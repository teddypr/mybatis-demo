package com.example.mybatisdemo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.naming.NameNotFoundException;
import java.util.Map;

import javax.naming.NameNotFoundException;
import java.util.Map;

public class ExceptionHandler {
    private Object body;

    @ExceptionHandler(value = javax.naming.NameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNameNotFoundException(
            NameNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }

}

