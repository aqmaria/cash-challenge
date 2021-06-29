package com.cash.challenge.controller;

import com.cash.challenge.dao.Dao;
import com.cash.challenge.entity.User;
import com.cash.challenge.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UsersController.class)
class UsersControllerTest {

    static final Long INVALID_USER_ID = 0L;

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void deleteUserWhenDoesntExistReturnsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/users/{id}",INVALID_USER_ID.toString()))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void saveUserWithNoDataReturnsClientError() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User userWithNoData = new User();
        userWithNoData.setEmail("");
        userWithNoData.setFirstName("");
        userWithNoData.setLastName("");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userWithNoData)))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

}