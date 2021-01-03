package com.example.demo;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "sensordata")
public class SensorData {

    public SensorData(){
    }

    public SensorData(Sensor sensor, int level, Instant readTimeStamp){
        this.sensor = sensor;
        this.level = level;
        this.readTimeStamp = readTimeStamp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="level")
    private int level;


    @Column(name = "read_timestamp")
    private Instant readTimeStamp = Instant.now();


    @ManyToOne(targetEntity = Sensor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id", nullable = true)
    private Sensor sensor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Instant getReadTimeStamp() {
        return readTimeStamp;
    }

    public void setReadTimeStamp(Instant readTimeStamp) {
        this.readTimeStamp = readTimeStamp;
    }
}
