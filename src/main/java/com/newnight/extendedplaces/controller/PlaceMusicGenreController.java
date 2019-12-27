package com.newnight.extendedplaces.controller;

import com.newnight.extendedplaces.model.PlaceMusicGenre;
import com.newnight.extendedplaces.dao.PlaceMusicGenreRepository;
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
