package com.newnight.extendedplaces.repositories;

import com.newnight.extendedplaces.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlacesRepository extends JpaRepository<Place, Integer> {
    @Query(value = "SELECT * FROM places p INNER JOIN place_music_genre pmg ON p.google_id = pmg.place_id", nativeQuery = true)
    List<Place> findAll();

//    @Query(value = "SELECT * FROM places p INNER JOIN place_music_genre pmg ON p.google_id = pmg.place_id", nativeQuery = true)    //This is using a named query method
//    List<Place> findAllWithDescriptionQuery();
}
