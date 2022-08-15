package com.carRentalManager.controller;

import com.carRentalManager.exception.ModelNotFoundException;
import com.carRentalManager.model.Model;
import com.carRentalManager.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/getModel/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable("id") int id) {
        Model model = modelRepository.findById(id).orElseThrow(
                () -> new ModelNotFoundException("The car with the id " + id + " was not found")
        );
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
