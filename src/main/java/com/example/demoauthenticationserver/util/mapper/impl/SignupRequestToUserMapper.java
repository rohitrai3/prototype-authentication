package com.example.demoauthenticationserver.util.mapper.impl;

import com.example.demoauthenticationserver.dto.SignupRequest;
import com.example.demoauthenticationserver.model.Role;
import com.example.demoauthenticationserver.model.User;
import com.example.demoauthenticationserver.util.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SignupRequestToUserMapper implements Mapper<SignupRequest, User> {

    @Autowired
    Mapper<String, Role> stringToRoleMapper;

    @Override
    public User map(SignupRequest request) {
        Set<Role> roles = request.getRoles()
                .stream()
                .map(roleName -> stringToRoleMapper.map(roleName))
                .collect(Collectors.toSet());

        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .roles(roles).build();
    }

}
