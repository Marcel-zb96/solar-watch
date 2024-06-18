package com.codecool.solarwatch.service;

import com.codecool.solarwatch.exception.geo.InvalidCityException;
import com.codecool.solarwatch.model.location_detail.City;
import com.codecool.solarwatch.model.location_detail.GeoCoordinateList;
import com.codecool.solarwatch.repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class LocationService {
    private static final String API_KEY = "1d80ab6520793e26301e3983035b2dc4";
    private final WebClient webClient;
    private final CityRepository cityRepository;

    public LocationService(WebClient webClient, CityRepository cityRepository) {
        this.webClient = webClient;
        this.cityRepository = cityRepository;
    }

    public City getCityCoordinatesByName(String cityName) {
        Optional<City> city = cityRepository.getCitiesByName(cityName);

        return city.orElseGet(() -> getLocationDetailForCityByName(cityName));

    }

    private City getLocationDetailForCityByName(String cityName) {

        String url = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=%s&appid=%s", cityName, 1, API_KEY);

        GeoCoordinateList geoCoordinateList = webClient
                .get()
                .uri(url)
                .retrieve() // sends the actual request
                .bodyToMono(GeoCoordinateList.class) // parses the response
                .block();

        if (geoCoordinateList != null && !geoCoordinateList.isEmpty()) {
            City city = new City(
                    geoCoordinateList.get(0).name(),
                    geoCoordinateList.get(0).lat(),
                    geoCoordinateList.get(0).lon(),
                    geoCoordinateList.get(0).state(),
                    geoCoordinateList.get(0).country());
            cityRepository.save(city);
            return city;

        } else {
            throw new InvalidCityException();
        }
    }

}
