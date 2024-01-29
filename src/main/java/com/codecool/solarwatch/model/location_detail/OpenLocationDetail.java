package com.codecool.solarwatch.model.location_detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OpenLocationDetail(String name, String lat, String lon, String country) {
}
