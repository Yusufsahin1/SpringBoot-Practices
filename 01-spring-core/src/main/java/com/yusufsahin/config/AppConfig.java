package com.yusufsahin.config;


import com.yusufsahin.model.User;
import com.yusufsahin.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        UserService userService = new UserService();

        List<User> userList = new ArrayList<>();
        userList.add(new User("Yusuf"));
        userList.add(new User("Muhammet"));
        userList.add(new User("Mehmet"));
        userList.add(new User("Ali"));

        userService.setUserList(userList);

        return userService;
    }
}
