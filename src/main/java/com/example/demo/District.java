package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="district")
public class District {

    public District(){
    }

    public District(String name, CityHall cityHall){
        this.name = name;
        this.cityHall = cityHall;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @ManyToOne(targetEntity = CityHall.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "cityhall_id", referencedColumnName = "id", nullable = true)
    private CityHall cityHall;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityHall getCityHall() {
        return cityHall;
    }

    public void setCityHall(CityHall cityHall) {
        this.cityHall = cityHall;
    }


    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
