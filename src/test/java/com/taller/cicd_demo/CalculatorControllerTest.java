package com.taller.cicd_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSum() throws Exception {
        mockMvc.perform(get("/api/sum")
                .param("a", "3")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    void testMultiply() throws Exception {
        mockMvc.perform(get("/api/multiply")
                .param("a", "3")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));
    }

    @Test
    void testHealthCheck() throws Exception {
        mockMvc.perform(get("/api/health-check"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }
}
