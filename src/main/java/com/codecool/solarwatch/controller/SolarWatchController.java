package com.codecool.solarwatch.controller;

import com.codecool.solarwatch.model.location_detail.City;
import com.codecool.solarwatch.model.solar_detail.SolarTime;
import com.codecool.solarwatch.model.solar_detail.SunriseSunsetInfo;
import com.codecool.solarwatch.service.LocationService;
import com.codecool.solarwatch.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class SolarWatchController {

    private final LocationService locationService;
    private final SolarService solarService;

    @Autowired
    public SolarWatchController(LocationService locationService, SolarService solarService) {
        this.locationService = locationService;
        this.solarService = solarService;
    }

    @GetMapping("/solartimes")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getSunsetSunriseDates(@RequestParam String cityName, @RequestParam LocalDate date) {

        City city = getLocationDetail(cityName);

        SunriseSunsetInfo sunriseSunsetInfo = solarService.getSolarDetail(city, date);

        return ResponseEntity.ok(sunriseSunsetInfo);
    }

    private City getLocationDetail(String city) {
        return locationService.getCityCoordinatesByName(city);
    }
}
