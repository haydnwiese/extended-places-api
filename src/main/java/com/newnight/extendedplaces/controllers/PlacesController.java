package com.newnight.extendedplaces.controllers;

import com.newnight.extendedplaces.models.DressCode;
import com.newnight.extendedplaces.models.MusicGenre;
import com.newnight.extendedplaces.models.Place;
import com.newnight.extendedplaces.models.VenueSize;
import com.newnight.extendedplaces.repositories.PlaceMusicGenreRepository;
import com.newnight.extendedplaces.repositories.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/places-filtered")
    public List<Place> filteredPlaces(@RequestParam VenueSize size,
                                      @RequestParam(name = "dress_code") DressCode dressCode,
                                      @RequestParam(name = "music_genre") MusicGenre musicGenre) {
        return repository.findBySizeAndDressCodeAndMusicGenres(size, dressCode, musicGenre);
    }

}
