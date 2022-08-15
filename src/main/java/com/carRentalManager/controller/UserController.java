package com.carRentalManager.controller;

import com.carRentalManager.exception.UserNotFoundException;
import com.carRentalManager.model.Reservation;
import com.carRentalManager.model.User;
import com.carRentalManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser (@RequestBody User user) {
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("The user with the id " + id + " was not found")
        );
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findUserByName")
    public ResponseEntity<List<User>> findReservationByReservationCode(String username) {
        List<User> user = userRepository.getUserByName(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
