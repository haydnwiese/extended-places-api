package com.newnight.extendedplaces.repositories;

import com.newnight.extendedplaces.models.DressCode;
import com.newnight.extendedplaces.models.MusicGenre;
import com.newnight.extendedplaces.models.Place;
import com.newnight.extendedplaces.models.VenueSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlacesRepository extends JpaRepository<Place, Integer> {
//    @Query(value = "SELECT * FROM places p INNER JOIN place_music_genre pmg ON p.google_id = pmg.place_id", nativeQuery = true)
//    @Query(value = "SELECT DISTINCT p, pmg FROM Place p INNER JOIN PlaceMusicGenre pmg ON p.googleId = pmg.placeId", nativeQuery = false)
    List<Place> findAll();

    @Query("SELECT p FROM Place p INNER JOIN p.musicGenres pmg ON pmg.musicGenre = :musicGenre AND p.size = :size AND p.dressCode = :dressCode")
    List<Place> findBySizeAndDressCodeAndMusicGenres(VenueSize size, DressCode dressCode, MusicGenre musicGenre);
}
