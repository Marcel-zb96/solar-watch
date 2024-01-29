package com.codecool.solarwatch.model.solar_detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OpenSolarDetail(OpenSolarDetailResult results, String status, String tzid) {
}
