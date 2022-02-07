package com.DU.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.hamcrest.Matchers;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class AgentsControllerTest {

    private MockMvc mockMvc;

    // @Mock
    // private HelloService helloService;

    @InjectMocks
    private AgentsController agentsController;

    @InjectMocks
    private IndexController indexController;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(indexController)
                .build();
    }

    @Test
    void testCreateclient() {

    }

    @Test
    void testDeletAgent() {

    }

    @Test
    void testGetAgentById() {

    }

    @Test
    void testGetAllAgents() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateAgent() {

    }
}
