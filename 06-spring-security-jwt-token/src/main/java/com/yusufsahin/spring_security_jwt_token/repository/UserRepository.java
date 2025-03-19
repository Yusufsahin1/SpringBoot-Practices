package com.yusufsahin.spring_security_jwt_token.repository;

import com.yusufsahin.spring_security_jwt_token.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String userName);
}
