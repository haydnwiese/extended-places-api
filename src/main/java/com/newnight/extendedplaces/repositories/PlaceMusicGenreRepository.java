package com.newnight.extendedplaces.repositories;

import com.newnight.extendedplaces.models.PlaceMusicGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceMusicGenreRepository extends JpaRepository<PlaceMusicGenre, Integer> {
    List<PlaceMusicGenre> findAllByPlaceId(String placeId);
}
