package com.yusufsahin.spring_security_jwt_token.service;

import com.yusufsahin.spring_security_jwt_token.dto.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class AuthService {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String generateToken(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(),
                request.password())); //authentication.getPrincipal()

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.username());
        }

        log.info("invalid username {}", request.username());
        throw new UsernameNotFoundException("invalid username {} " + request.username());
    }
}
