package com.codecool.solarwatch.model.solar_detail;

import java.time.ZonedDateTime;

public record SolarTime(ZonedDateTime sunrise, ZonedDateTime sunset, String location) {
}
