package com.example.geektrust.services;

import com.example.geektrust.entities.Driver;
import com.example.geektrust.repositories.IDriverRepository;

import java.util.List;

public class DriverService implements IDriverService{

    private final IDriverRepository driverRepository;

    public DriverService(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDriver() {
        return driverRepository.findAll();
    }

    @Override
    public void addDriver(Driver driver) {
        driverRepository.addDriver(driver);
    }
}
