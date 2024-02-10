package com.codecool.solarwatch.controller;

import com.codecool.solarwatch.model.location_detail.LocationDetail;
import com.codecool.solarwatch.model.solar_detail.SolarDetail;
import com.codecool.solarwatch.service.OpenLocationService;
import com.codecool.solarwatch.service.OpenSolarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class SolarWatchController {

    private final OpenLocationService openLocationService;
    private final OpenSolarService openSolarService;


    public SolarWatchController(OpenLocationService openLocationService, OpenSolarService openSolarService) {
        this.openLocationService = openLocationService;
        this.openSolarService = openSolarService;
    }

    @GetMapping("/solartimes")
    public ResponseEntity<?> getSunsetSunriseDates(@RequestParam String city, @RequestParam LocalDate date) {

        if (date.isBefore(LocalDate.now())) {
            return ResponseEntity.badRequest().body("Date must not be in the past");
        }

        LocationDetail locationDetail = getLocationDetail(city);
        var solarDetail = Arrays.stream(new SolarDetail[]{openSolarService.getSolarDetailByLocationByDate(locationDetail, date)}).toList();
        //SolarDetail solarDetail = openSolarService.getSolarDetailByLocationByDate(locationDetail, date);

        return ResponseEntity.ok(solarDetail);
    }

    private LocationDetail getLocationDetail(String city) {
        return openLocationService.getLocationDetailForCityByName(city);
    }
}
