package com.codecool.solarwatch.model.solar_detail;

import com.codecool.solarwatch.model.location_detail.City;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sunrise-sunset")
public class SunriseSunsetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDate date;
    private LocalTime sunrise;
    private LocalTime sunset;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public SunriseSunsetInfo(LocalDate date, LocalTime sunrise, LocalTime sunset, City city) {
        this.date = date;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.city = city;
    }

    public SunriseSunsetInfo() {

    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public City getCity() {
        return city;
    }

}
