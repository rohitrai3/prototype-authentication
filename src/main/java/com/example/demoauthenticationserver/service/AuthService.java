package com.example.demoauthenticationserver.service;

import com.example.demoauthenticationserver.dto.SignupRequest;
import com.example.demoauthenticationserver.dto.SignupResponse;
import org.springframework.web.servlet.view.RedirectView;

public interface AuthService {

    SignupResponse signup(SignupRequest request);
    RedirectView login(Long id);

}
