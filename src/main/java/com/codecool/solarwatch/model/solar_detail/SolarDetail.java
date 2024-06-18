package com.codecool.solarwatch.model.solar_detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SolarDetail(SolarDetailResult results, String status, String tzid) {
}
