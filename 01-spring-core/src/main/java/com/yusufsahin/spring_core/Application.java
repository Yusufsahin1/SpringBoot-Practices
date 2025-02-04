package com.yusufsahin.spring_core;

import com.yusufsahin.config.AppConfig;
import com.yusufsahin.model.User;
import com.yusufsahin.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);

		for (User user : userService.getUserList()) {
			System.out.println(user.getFirstName());
		}
		// The userList (bean) was accessed from the main class within the context.
		// Thanks to the Context - Bean, userList can also be accessed from different classes.
		// If Context - Bean was not used, a new object would be created each time with ‘new’ from the UserService class.
		// This is bad for memory management and the list is reset every time a new object is generated.
	}
}
