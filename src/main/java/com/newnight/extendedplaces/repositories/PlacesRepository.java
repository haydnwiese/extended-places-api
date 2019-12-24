package com.newnight.extendedplaces.repositories;

import com.newnight.extendedplaces.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Place, Integer> {
}
