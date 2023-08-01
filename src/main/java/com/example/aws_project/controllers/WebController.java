package com.example.aws_project.controllers;

import com.example.aws_project.models.User;
import com.example.aws_project.service.UserService;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        return ResponseEntity.ok().body(user1);
    }
}
    @GetMapping("/user")
    public ResponseEntity<User> getProduct(@RequestParam String emailaddress)
    {
        User user1 =userservice.getUserDetails(emailaddress);
        if(user1==null)
        {
            return ResponseEntity.badRequest().body(user1);
        }
        else
        {
            return ResponseEntity.ok().body(user1);
        }
    }
    @GetMapping("/getuser")
    public ResponseEntity<User> getProducts(@RequestBody Map<String, String> emailaddress)
    {
        User user1 =userservice.getUserDetails(emailaddress.get("emailaddress"));
        if(user1==null)
        {
            return ResponseEntity.badRequest().body(user1);
        }
        else
        {
            return ResponseEntity.ok().body(user1);
        }
    }

}
