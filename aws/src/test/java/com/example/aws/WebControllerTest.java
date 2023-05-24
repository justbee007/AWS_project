package com.example.aws;

import com.example.aws.controllers.WebController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
