package com.newnight.extendedplaces.dao;

import com.newnight.extendedplaces.model.DressCode;
import com.newnight.extendedplaces.model.MusicGenre;
import com.newnight.extendedplaces.model.Place;
import com.newnight.extendedplaces.model.VenueSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PlacesRepository extends JpaRepository<Place, Integer> {
//    @Query(value = "SELECT * FROM places p INNER JOIN place_music_genre pmg ON p.google_id = pmg.place_id", nativeQuery = true)
//    @Query(value = "SELECT DISTINCT p, pmg FROM Place p INNER JOIN PlaceMusicGenre pmg ON p.googleId = pmg.placeId", nativeQuery = false)
    List<Place> findAll();

    Place findFirstByGoogleId(String googleId);

    long deleteByGoogleId(String googleId);

    @Query("SELECT p FROM Place p INNER JOIN p.musicGenres pmg ON pmg.musicGenre = :musicGenre AND p.size = :size AND p.dressCode = :dressCode")
    List<Place> findBySizeAndDressCodeAndMusicGenres(VenueSize size, DressCode dressCode, MusicGenre musicGenre);
}
