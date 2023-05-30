package com.example.aws_project;

import com.example.aws_project.controllers.WebController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebControllerTest {
    @InjectMocks
    WebController webcontroller = new WebController();
    @Test
    void shouldCreateTutorial() throws Exception
    {
//        MvcResult mvcc = mvc.perform(post("/healthz")).andExpect(status().isOk()).andReturn();
        ResponseEntity responseEntity = webcontroller.greetMessage();
        assertEquals("200 OK",responseEntity.getStatusCode().toString());

    }
}
