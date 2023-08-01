package com.example.aws_project.service;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UtilsService {

    public String hashpassword(String password)
    {
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }
    public boolean dehaspassword(String password,String hashed)
    {
        return BCrypt.checkpw(password,hashed);
    }
}
