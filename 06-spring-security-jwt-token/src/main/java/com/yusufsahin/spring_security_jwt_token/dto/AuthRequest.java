package com.yusufsahin.spring_security_jwt_token.dto;

public record AuthRequest (
        String username,
        String password
){
}
