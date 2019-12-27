package com.newnight.extendedplaces.controller;

import com.newnight.extendedplaces.model.*;
import com.newnight.extendedplaces.dao.PlaceMusicGenreRepository;
import com.newnight.extendedplaces.dao.PlacesRepository;
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

    @GetMapping("/places/{id}")
    public Place fetchPlace(String id) {
        return placesRepository.findFirstByGoogleId(id);
    }

    @GetMapping("/places-filtered")
    public List<Place> filteredPlaces(@RequestParam VenueSize size,
                                      @RequestParam(name = "dress_code") DressCode dressCode,
                                      @RequestParam(name = "music_genre") MusicGenre musicGenre) {
        return placesRepository.findBySizeAndDressCodeAndMusicGenres(size, dressCode, musicGenre);
    }

    @PostMapping("/places")
    public Place createPlace(@RequestBody Place body) {
        for (PlaceMusicGenre musicGenre : body.getMusicGenres()) {
            musicGenre.setPlaceId(body.getGoogleId());
            placeMusicGenreRepository.save(musicGenre);
        }
        return placesRepository.save(body);
    }

    @PutMapping("/places/{id}")
    public boolean updatePlace(@PathVariable String id, @RequestBody Place body) {
        Place placeToUpdate = placesRepository.findFirstByGoogleId(id);
        placeToUpdate.setName(body.getName());
        placeToUpdate.setSize(body.getSize());
        placeToUpdate.setDressCode(body.getDressCode());
        placesRepository.save(placeToUpdate);
        // TODO: Figure out how to update music genres as well
        return true;
    }

    @DeleteMapping("/places/{id}")
    public boolean deletePlace(@PathVariable String id) {
        //id refers to the google id of the place record
        long deletedAmount = placesRepository.deleteByGoogleId(id);
        placeMusicGenreRepository.deleteByPlaceId(id);
        return deletedAmount > 0;
    }
}
