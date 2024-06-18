package com.codecool.solarwatch.model.location_detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCoordinateList extends ArrayList<GeoCoordinates> {
}
