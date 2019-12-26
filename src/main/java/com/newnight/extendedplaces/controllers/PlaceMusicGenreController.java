package com.newnight.extendedplaces.controllers;

import com.newnight.extendedplaces.models.PlaceMusicGenre;
import com.newnight.extendedplaces.repositories.PlaceMusicGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceMusicGenreController {

    @Autowired
    PlaceMusicGenreRepository repository;

    @GetMapping("/music-genres")
    public List<PlaceMusicGenre> index() {
        return repository.findAll();
    }
}
