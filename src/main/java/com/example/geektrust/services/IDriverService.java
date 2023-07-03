package com.example.geektrust.services;

import com.example.geektrust.entities.Driver;

import java.util.List;

public interface IDriverService {
    void addDriver(Driver driver);

    List<Driver> getAllDriver();
}
