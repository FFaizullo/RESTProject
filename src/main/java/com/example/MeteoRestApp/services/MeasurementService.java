package com.example.MeteoRestApp.services;

import com.example.MeteoRestApp.models.Measurement;
import com.example.MeteoRestApp.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementsRepository measurementsRepository;
    private final SensorsService sensorsService;
    @Autowired
    public MeasurementService(MeasurementsRepository measurementsRepository, SensorsService sensorsService) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsService = sensorsService;
    }

    public List<Measurement> findAll(){
        return measurementsRepository.findAll();
    }

    public int countRainyDays(){
        List<Measurement> measurements = measurementsRepository.findByRainingEquals(true);
        return measurements.size();
    }


    @Transactional
    public void save(Measurement measurement){
        measurement.setTime(LocalDateTime.now());
        measurement.setSensor(sensorsService.findByName(measurement.getSensor().getName()).get(0));
        measurementsRepository.save(measurement);
    }
}
