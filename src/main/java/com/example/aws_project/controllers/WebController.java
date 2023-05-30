package com.example.aws_project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping("/healthz")
    public ResponseEntity greetMessage()
    {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
