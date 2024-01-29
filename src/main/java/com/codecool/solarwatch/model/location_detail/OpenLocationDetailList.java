package com.codecool.solarwatch.model.location_detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLocationDetailList extends ArrayList<OpenLocationDetail> {
}
