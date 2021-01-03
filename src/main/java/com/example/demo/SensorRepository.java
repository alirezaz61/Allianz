package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Long> {

    Sensor findById(long id);

}
