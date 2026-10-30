package com.ndt.bookshop_authentication.controller;

import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.http.MediaType;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


import com.ndt.bookshop_authentication.config.SecurityConfig;
import com.ndt.bookshop_authentication.payload.req.AuthReq;
import com.ndt.bookshop_authentication.service.contract.AuthService;


@WebMvcTest(AuthController.class)
@EnableWebSecurity
@Import(SecurityConfig.class)
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AuthService authService;


    @Test
    void signIn_validRequest_returnsToken() throws Exception {
        when(authService.signIn(any(AuthReq.class))).thenReturn("fake-jwt");

        String body = """
            {"email":"test@example.com","password":"123456"}
            """;

        mockMvc.perform(
                post("/auth/sign-in")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.message").value("Sign in successful"))
            .andExpect(jsonPath("$.data").value("fake-jwt"));
    }


    @Test
    void signIn_malformedBody_returnsClientError() throws Exception {
        mockMvc.perform(
                post("/auth/sign-in")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("not-json")
            )
            .andExpect(status().is4xxClientError());
    }
}
