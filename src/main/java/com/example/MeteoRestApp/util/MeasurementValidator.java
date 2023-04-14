package com.example.MeteoRestApp.util;

import com.example.MeteoRestApp.models.Measurement;
import com.example.MeteoRestApp.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorsService sensorsService;
    @Autowired
    public MeasurementValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;
        if (sensorsService.findByName(measurement.getSensor().getName()).isEmpty()){
            errors.rejectValue("sensor", "", "This sensor is not registered");
        }
    }
}
