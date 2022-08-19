package com.website.rednation.controllers;

import com.website.rednation.expections.ResourceNotFoundException;
import com.website.rednation.models.User;
import com.website.rednation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List <User> getAllUsers() {
        return userRepository.findAll();

    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity < User > getUserByUsername(@PathVariable String username) {

            User user = userRepository.findById(username)
                    .orElseThrow(() -> new ResourceNotFoundException("User not exist with username :" + username));
            return ResponseEntity.ok(user);
    }


    @PutMapping("/users/{username}")
    public ResponseEntity < User > updateUser(@PathVariable String username, @RequestBody User userDetails) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with username :" + username));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity <Map< String, Boolean >> deleteUser(@PathVariable String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + username));

        userRepository.delete(user);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
