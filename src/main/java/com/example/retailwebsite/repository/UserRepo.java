package com.example.retailwebsite.repository;

import com.example.retailwebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

    List<User> findByAffiliated(boolean affiliated);


}
