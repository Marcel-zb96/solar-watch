package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.location_detail.LocationDetail;
import com.codecool.solarwatch.model.solar_detail.OpenSolarDetail;
import com.codecool.solarwatch.model.solar_detail.SolarDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class OpenSolarService {
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OpenLocationService.class);

    public OpenSolarService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SolarDetail getSolarDetailByLocationByDate(LocationDetail locationDetail, LocalDate date) {

        String url = String.format("https://api.sunrise-sunset.org/json?lat=%s&lng=%s&date=%s&formatted=0", locationDetail.lat(), locationDetail.lon(), date.toString());
        System.out.println(url);
        OpenSolarDetail response = restTemplate.getForObject(url, OpenSolarDetail.class);

        logger.info("Response from Sunset-Sunrise API: {}", response);


        return new SolarDetail(
                response.results().sunrise(),
                response.results().sunset(),
                locationDetail.cityName()
        );
    }
}
