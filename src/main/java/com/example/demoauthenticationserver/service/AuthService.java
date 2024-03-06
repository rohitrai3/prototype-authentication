package com.example.demoauthenticationserver.service;

import com.example.demoauthenticationserver.dto.SignupRequest;
import com.example.demoauthenticationserver.dto.SignupResponse;

public interface AuthService {

    SignupResponse signup(SignupRequest request);

}
