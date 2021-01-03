package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DistrictRepository extends CrudRepository<District, Long> {
    List<District> findAll();
    District findById(long id);
    List<District> findAllByCityHall(CityHall cityHall);
}
