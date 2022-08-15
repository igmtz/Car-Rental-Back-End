package com.carRentalManager.controller;

import com.carRentalManager.exception.CarClassNotFoundException;
import com.carRentalManager.exception.UserNotFoundException;
import com.carRentalManager.model.CarClass;
import com.carRentalManager.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/getClass/{id}")
    public ResponseEntity<CarClass> getClassById(@PathVariable("id") int id) {
        CarClass carClass = classRepository.findById(id).orElseThrow(
                () -> new CarClassNotFoundException("The class with the id " + id + " was not found")
        );
        return new ResponseEntity<>(carClass, HttpStatus.OK);
    }
}
