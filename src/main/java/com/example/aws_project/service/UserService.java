package com.example.aws_project.service;

import com.example.aws_project.models.User;
import com.example.aws_project.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserService {
@Autowired
private UserRepository userrepository;
@Autowired UtilsService utilsservice;

    public User saveuser(User user)
    { User useri1 = userrepository.findByEmailaddress(user.getEmailaddress());
        if(useri1!=null)
        {
            return null;
        }
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            user.setAccount_created(now);
            user.setAccount_updated(now);
            user.setPassword(utilsservice.hashpassword(user.getPassword()));
            System.out.println(user.getPassword());
            userrepository.save(user);
            return user;
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
public User getUserDetails(String emailaddress) {
    User user1 = userrepository.findByEmailaddress(emailaddress);
    if (user1 == null) {
        return null;
    } else {
        return user1;
    }
}
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
}
