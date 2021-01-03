package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {
    @Autowired
    SensorRepository sensorRepository;

    public Sensor Find(long id){
        return sensorRepository.findById(id);
    }
}
