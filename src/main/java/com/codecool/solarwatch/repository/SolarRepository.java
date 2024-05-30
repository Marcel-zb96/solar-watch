package com.codecool.solarwatch.repository;

import com.codecool.solarwatch.model.location_detail.City;
import com.codecool.solarwatch.model.solar_detail.SunriseSunsetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SolarRepository extends JpaRepository<SunriseSunsetInfo, Long> {

    Optional<SunriseSunsetInfo> getByCityAndDate(City city, LocalDate date);
}
