package com.example.aws_project.service;

import com.example.aws_project.models.User;
import com.example.aws_project.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {
@Autowired
    private UserRepository userrepository;
//@Autowired
//private Encoder encoder;
    public User saveuser(User user)
    { User useri1 = userrepository.findByEmailaddress(user.getEmailaddress());
        if(useri1!=null)
        {
//            return new ResponseEntity<>(
//                    "",
//                    HttpStatus.BAD_REQUEST);
            return null;
        }
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            user.setAccount_created(now);
            user.setAccount_updated(now);
//            user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));

//            userrepository.save(user);
//            user.setPassword(passwordEncoder.encode(user.getPassword()));

            return userrepository.save(user);
        }
    }
    public static String modeljsonstring(User user)
    {  String Json ="";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Json =  mapper.writeValueAsString(user);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Json;
    }
}
