package com.vinkaio.aitminiproject;

import com.vinkaio.aitminiproject.svcc.ServiceUtilC;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes=ServiceUtilC.class)
@AutoConfigureMockMvc
public class ServiceUtilCTest {
    
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGreetEndpoint() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/"))
       .andExpect(MockMvcResultMatchers.status().isOk());
  }
}