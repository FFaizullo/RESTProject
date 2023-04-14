package com.example.MeteoRestApp.util;

public class MeasurementNotAddedException extends RuntimeException{
    public MeasurementNotAddedException(String msg){
        super(msg);
    }
}
