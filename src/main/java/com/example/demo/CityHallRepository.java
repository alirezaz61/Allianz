package com.example.demo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityHallRepository extends CrudRepository<CityHall, Long> {

    List<CityHall> findAll();
    CityHall findById(long id);

    CityHall save(CityHall product);

}
