package com.draconomicon.api.repository;

import com.draconomicon.api.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByIdUser(Long id_user);
    void deleteAllByIdUser(Long id_user);
}