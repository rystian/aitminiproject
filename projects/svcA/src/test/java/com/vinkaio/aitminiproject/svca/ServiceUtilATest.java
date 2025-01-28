package com.vinkaio.aitminiproject.svca;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes=ServiceUtilA.class)
@AutoConfigureMockMvc
public class ServiceUtilATest {
    
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGreetEndpoint() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/"))
       .andExpect(MockMvcResultMatchers.status().isOk());
  }
}