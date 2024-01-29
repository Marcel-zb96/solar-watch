package com.codecool.solarwatch.model.solar_detail;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public record SolarDetail(ZonedDateTime sunrise, ZonedDateTime sunset, String location) {
}
