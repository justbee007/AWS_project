package com.example.aws_project.controllers;

import com.example.aws_project.models.User;
import com.example.aws_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    private UserService userservice;

    @GetMapping("/healthz")
    public ResponseEntity greetMessage()
    {

        return new ResponseEntity<>(HttpStatus.OK);
    }
@PostMapping("/adduser")
    public ResponseEntity<User> addProduct(@RequestBody User user)
{
    User user1 =userservice.saveuser(user);
    if(user1==null)
    {
        return ResponseEntity.badRequest().body(user1);
    }
    else
    {
        return ResponseEntity.badRequest().body(user1);
    }
}
}
