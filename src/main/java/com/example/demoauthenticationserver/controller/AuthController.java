package com.example.demoauthenticationserver.controller;

import com.example.demoauthenticationserver.dto.SignupRequest;
import com.example.demoauthenticationserver.dto.SignupResponse;
import com.example.demoauthenticationserver.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public SignupResponse signup(@RequestBody SignupRequest request) {

        return authService.signup(request);
    }

    @GetMapping("/login/{id}")
    public RedirectView login(@PathVariable Long id) {

        return authService.login(id);
    }

}
