package com.example.demoauthenticationserver.service.impl;

import com.example.demoauthenticationserver.dto.SignupRequest;
import com.example.demoauthenticationserver.dto.SignupResponse;
import com.example.demoauthenticationserver.model.User;
import com.example.demoauthenticationserver.repository.UserRepository;
import com.example.demoauthenticationserver.service.AuthService;
import com.example.demoauthenticationserver.util.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Mapper<SignupRequest, User> signupRequestToUserMapper;

    @Override
    public SignupResponse signup(SignupRequest request) {
        User user = signupRequestToUserMapper.map(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return SignupResponse.builder()
                .username(user.getUsername())
                .build();
    }

    @Override
    public RedirectView login(Long id) {

        return new RedirectView("http://localhost:8080/authorize/continue/" + id);
    }

}
