package com.draconomicon.api.repository;

import com.draconomicon.api.model.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}