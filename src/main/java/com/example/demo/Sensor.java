package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {
    public Sensor(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @OneToOne(mappedBy = "sensor")
    private District district;

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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
