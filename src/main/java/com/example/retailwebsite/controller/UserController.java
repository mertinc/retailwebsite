package com.example.retailwebsite.controller;

import com.example.retailwebsite.model.Inventory;
import com.example.retailwebsite.model.User;
import com.example.retailwebsite.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<User>();
            users.addAll(userRepo.findAll());
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepo.save(new User(user.getName(), user.getPassword(), user.isHascard(), user.getCardType(), user.isAffiliated(), Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        Optional<User> userData = userRepo.findById(id);
        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setName(user.getName());
            _user.setPassword(user.getPassword());
            _user.setHascard(user.isHascard());
            _user.setCardType(user.getCardType());
            _user.setAffiliated(user.isAffiliated());
            _user.setCreateDate(user.getCreateDate());
            return new ResponseEntity<>(userRepo.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
