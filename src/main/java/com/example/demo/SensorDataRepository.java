package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorDataRepository extends CrudRepository<SensorData, Long> {

    List<SensorData> findAll();
    List<SensorData> findBySensor(Sensor sensor);

    SensorData save(SensorData sensorData);
}
