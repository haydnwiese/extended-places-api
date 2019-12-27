package com.newnight.extendedplaces.controllers;

import com.newnight.extendedplaces.models.*;
import com.newnight.extendedplaces.repositories.PlaceMusicGenreRepository;
import com.newnight.extendedplaces.repositories.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlacesController {

    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    PlaceMusicGenreRepository placeMusicGenreRepository;

    @GetMapping("/places")
    public List<Place> index() {
        return placesRepository.findAll();
    }

    @GetMapping("/places-filtered")
    public List<Place> filteredPlaces(@RequestParam VenueSize size,
                                      @RequestParam(name = "dress_code") DressCode dressCode,
                                      @RequestParam(name = "music_genre") MusicGenre musicGenre) {
        return placesRepository.findBySizeAndDressCodeAndMusicGenres(size, dressCode, musicGenre);
    }

    @PostMapping("/place")
    public Place createPlace(@RequestBody Place body) {
        for (PlaceMusicGenre musicGenre : body.getMusicGenres()) {
            musicGenre.setPlaceId(body.getGoogleId());
            placeMusicGenreRepository.save(musicGenre);
        }
        return placesRepository.save(body);
    }
}
