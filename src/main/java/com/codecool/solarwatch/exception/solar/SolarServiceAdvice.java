package com.codecool.solarwatch.exception.solar;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SolarServiceAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidCoordinatesOrDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidCoordinatesOrDateHandler(InvalidCoordinatesOrDateException ex) {return ex.getMessage();}
}
