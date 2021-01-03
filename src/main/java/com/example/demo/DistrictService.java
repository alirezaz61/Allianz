package com.example.demo;

import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    public District Find(long id){
        return districtRepository.findById(id);
    }

    public List<District> Find(CityHall cityHall){
        return districtRepository.findAllByCityHall(cityHall);
    }
}
