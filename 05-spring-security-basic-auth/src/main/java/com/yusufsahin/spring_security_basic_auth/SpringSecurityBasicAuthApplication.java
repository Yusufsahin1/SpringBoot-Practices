package com.yusufsahin.spring_security_basic_auth;

import com.yusufsahin.spring_security_basic_auth.dto.CreateUserRequest;
import com.yusufsahin.spring_security_basic_auth.model.Role;
import com.yusufsahin.spring_security_basic_auth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityBasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public SpringSecurityBasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("Emin")
				.username("emin")
				.password("pass")
				.authorities(Role.ROLE_USER)
				.build();
		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("FSK")
				.username("fsk")
				.password("pass")
				.authorities(Role.ROLE_MOD)
				.build();
		userService.createUser(request2);


		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("No Name")
				.username("noname")
				.password("pass")
				.authorities(Role.ROLE_ADMIN)
				.build();
		userService.createUser(request3);
	}
}
