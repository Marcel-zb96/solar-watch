package com.codecool.solarwatch.model.solar_detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SolarDetailResult(ZonedDateTime sunrise, ZonedDateTime sunset) {
}
