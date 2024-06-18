package com.codecool.solarwatch.model.location_detail;

import java.math.BigDecimal;

public record LocationDetail(BigDecimal lon, BigDecimal lat, String cityName) {
}
