package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityHallService {
    @Autowired
    private CityHallRepository cityHallrepository;

    public List<CityHall> FindAll(){

        return cityHallrepository.findAll();
    }

    public CityHall Find(long id){
        return cityHallrepository.findById(id);
    }

}
