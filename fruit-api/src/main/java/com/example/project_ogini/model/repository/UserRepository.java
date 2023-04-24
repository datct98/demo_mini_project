package com.example.project_ogini.model.repository;

import com.example.project_ogini.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String userName);

    User findUserById(Integer id);
}
