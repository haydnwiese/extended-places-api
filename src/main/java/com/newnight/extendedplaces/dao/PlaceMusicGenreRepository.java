package com.newnight.extendedplaces.dao;

import com.newnight.extendedplaces.model.PlaceMusicGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PlaceMusicGenreRepository extends JpaRepository<PlaceMusicGenre, Integer> {
    List<PlaceMusicGenre> findAllByPlaceId(String placeId);

    long deleteByPlaceId(String placeId);
}
