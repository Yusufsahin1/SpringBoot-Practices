package com.yusufsahin.spring_security_jwt_token.controller;

import com.yusufsahin.spring_security_jwt_token.dto.AuthRequest;
import com.yusufsahin.spring_security_jwt_token.dto.CreateUserRequest;
import com.yusufsahin.spring_security_jwt_token.model.User;
import com.yusufsahin.spring_security_jwt_token.service.AuthService;
import com.yusufsahin.spring_security_jwt_token.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello World!";
    }

    @PostMapping("/addNewUser")
    public User addUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request) {
        return authService.generateToken(request);
    }

    @GetMapping("/user")
    public String getUserString() {
        return "This is USER!";
    }

    @GetMapping("/admin")
    public String getAdminString() {
        return "This is ADMIN!";
    }
}
