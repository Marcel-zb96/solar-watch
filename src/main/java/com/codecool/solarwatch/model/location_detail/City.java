package com.codecool.solarwatch.model.location_detail;

import com.codecool.solarwatch.model.solar_detail.SunriseSunsetInfo;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long city_id;
    private String name;
    private double latitude;
    private double longitude;
    private String country;
    private String state;

    @OneToMany(mappedBy = "city")
    private List<SunriseSunsetInfo> sunriseSunsetInfoList;

    public City(String name, double latitude, double longitude, String country, String state) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.state = state;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }
}
