package com.example.retailwebsite.repository;

import com.example.retailwebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    List<User> findByAffiliated(boolean affiliated);

    Optional<User> findById(long id);
}
