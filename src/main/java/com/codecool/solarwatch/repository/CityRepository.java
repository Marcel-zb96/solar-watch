package com.codecool.solarwatch.repository;

import com.codecool.solarwatch.model.location_detail.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> getCitiesByName(String name);
}
