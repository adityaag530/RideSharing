package com.example.geektrust.repositories;

import com.example.geektrust.entities.Driver;

import java.util.List;

public interface IDriverRepository {
    Driver findDriverById(String driverId);

    void addDriver(Driver driver);
    List<Driver> findAll();
}
