package com.example.demoauthenticationserver.service.impl;

import com.example.demoauthenticationserver.dto.SignupRequest;
import com.example.demoauthenticationserver.dto.SignupResponse;
import com.example.demoauthenticationserver.model.User;
import com.example.demoauthenticationserver.repository.UserRepository;
import com.example.demoauthenticationserver.service.AuthService;
import com.example.demoauthenticationserver.util.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Mapper<SignupRequest, User> signupRequestToUserMapper;

    @Override
    public SignupResponse signup(SignupRequest request) {
        User user = signupRequestToUserMapper.map(request);

        user = userRepository.save(user);

        return SignupResponse.builder()
                .username(user.getUsername())
                .build();
    }

}