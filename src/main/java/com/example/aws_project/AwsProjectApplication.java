package com.example.aws_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.aws_project.repository")
public class AwsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsProjectApplication.class, args);
    }

}
