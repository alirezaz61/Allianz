package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SensorDataService {
    @Autowired
    SensorDataRepository sensorDataRepository;

    public List<SensorData> Find(Sensor sensor){

        return sensorDataRepository.findBySensor(sensor);
    }

    public SensorData Save(SensorData sensorData){
        return sensorDataRepository.save(sensorData);
    }

}
