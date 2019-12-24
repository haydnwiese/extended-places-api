package com.newnight.extendedplaces.controllers;

import com.newnight.extendedplaces.models.Place;
import com.newnight.extendedplaces.repositories.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlacesController {

    @Autowired
    PlacesRepository repository;

    @GetMapping("/places")
    public List<Place> index() {
        return repository.findAll();
    }

}
