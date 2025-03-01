package com.yusufsahin.spring_security_basic_auth.dto;

import com.yusufsahin.spring_security_basic_auth.model.Role;
import lombok.Builder;

@Builder
public record CreateUserRequest (
        String name,
        String username,
        String password,
        Role authorities
){
}
