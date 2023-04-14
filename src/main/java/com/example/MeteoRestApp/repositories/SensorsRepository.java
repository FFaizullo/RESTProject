package com.example.MeteoRestApp.repositories;

import com.example.MeteoRestApp.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByName(String name);
}
