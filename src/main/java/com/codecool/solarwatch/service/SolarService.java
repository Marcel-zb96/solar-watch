package com.codecool.solarwatch.service;

import com.codecool.solarwatch.exception.solar.InvalidCoordinatesOrDateException;
import com.codecool.solarwatch.model.location_detail.City;
import com.codecool.solarwatch.model.location_detail.LocationDetail;
import com.codecool.solarwatch.model.solar_detail.SolarDetail;
import com.codecool.solarwatch.model.solar_detail.SolarTime;
import com.codecool.solarwatch.model.solar_detail.SunriseSunsetInfo;
import com.codecool.solarwatch.repository.SolarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SolarService {
    private final WebClient webClient;
    private final SolarRepository solarRepository;

    public SolarService(WebClient webClient, SolarRepository solarRepository) {
        this.webClient = webClient;
        this.solarRepository = solarRepository;
    }

    public SunriseSunsetInfo getSolarDetail(City city, LocalDate date) {


        Optional<SunriseSunsetInfo> sunriseSunset = solarRepository.getByCityAndDate(city, date);

        return sunriseSunset.orElseGet(() -> fetchSolarData(city, date));


    }

    private static String getUrl(City city, LocalDate date) {
        return String.format("https://api.sunrise-sunset.org/json?lat=%s&lng=%s&date=%s&formatted=0", city.getLatitude(), city.getLongitude(), date.toString());
    }

    private SunriseSunsetInfo fetchSolarData(City city, LocalDate date) {
        String url = getUrl(city, date);
        SolarDetail response = webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(SolarDetail.class)
                .block();

        if (response != null) {

            SunriseSunsetInfo sunriseSunsetInfo = new SunriseSunsetInfo(
                    date,
                    response.results().sunrise().toLocalTime(),
                    response.results().sunset().toLocalTime(),
                    city
            );

            solarRepository.save(sunriseSunsetInfo);
            return sunriseSunsetInfo;

        } else {
            throw new InvalidCoordinatesOrDateException();
        }
    }
}
