package com.example.demoauthenticationserver.util.mapper.impl;

import com.example.demoauthenticationserver.model.Role;
import com.example.demoauthenticationserver.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleMapper implements Mapper<String, Role> {

    @Override
    public Role map(String roleName) {

        return Role.builder().role(roleName).build();
    }

}
