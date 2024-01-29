package com.codecool.solarwatch.service;

import com.codecool.solarwatch.model.location_detail.LocationDetail;
import com.codecool.solarwatch.model.location_detail.OpenLocationDetail;
import com.codecool.solarwatch.model.location_detail.OpenLocationDetailList;
import com.codecool.solarwatch.model.solar_detail.OpenSolarDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OpenLocationService {
    private static final String API_KEY = "1d80ab6520793e26301e3983035b2dc4";
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OpenLocationService.class);
    private static final int responseLimit = 1;

    public OpenLocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public LocationDetail getLocationDetailForCityByName(String city) {
        class Response extends ArrayList<Map<String, Object>> {}

        String url = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=%s&appid=%s", city, responseLimit, API_KEY);

        OpenLocationDetailList response = restTemplate.getForObject(url, OpenLocationDetailList.class);

        logger.info("Response from Geocodeing API: {}", response);

        return new LocationDetail(
                new BigDecimal(response.get(0).lon()),
                new BigDecimal(response.get(0).lat()),
                response.get(0).name()
        );
    }

}
