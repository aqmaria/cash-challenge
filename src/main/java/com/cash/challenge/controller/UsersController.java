package com.cash.challenge.controller;

import com.cash.challenge.entity.User;
import com.cash.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id:\\d+}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long userId) {
        User user = userService.get(userId);
        if(user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/users/{id:\\d+}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long userId) {
        if(userService.get(userId) == null)
            return ResponseEntity.notFound().build();

        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
        userService.insert(user);
        return ResponseEntity.noContent().build();
    }

}
