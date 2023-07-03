package com.example.geektrust.repositories;

import com.example.geektrust.entities.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository implements IDriverRepository{

    private final List<Driver> drivers = new ArrayList<>();

    @Override
    public void addDriver(Driver driver) {
        drivers.add(driver);
//        System.out.println("Driver Added Successfully!");
    }

    @Override
    public Driver findDriverById(String driverId) {
        for(Driver d: drivers){
            if(driverId.equals( d.getDriverId() ) ){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Driver> findAll() {
        return drivers;
    }
}