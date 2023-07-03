package com.example.geektrust.entities;

import java.util.List;

public class Rider {
    private String riderId;
    private double x_coordinate_of_rider;
    private double y_coordinate_of_rider;

    private List<Driver> driversMatched;

    private Riding rides;

    public Riding getRides() {
        return rides;
    }

    public void setRides(Riding rides) {
        this.rides = rides;
    }

    public List<Driver> getDriversMatched() {
        return driversMatched;
    }

    public void setDriversMatched(List<Driver> driversMatched) {
        this.driversMatched = driversMatched;
    }

    public Rider(String riderId, double x_coordinate_of_rider, double y_coordinate_of_rider) {
        this.riderId = riderId;
        this.x_coordinate_of_rider = x_coordinate_of_rider;
        this.y_coordinate_of_rider = y_coordinate_of_rider;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public double getX_coordinate_of_rider() {
        return x_coordinate_of_rider;
    }

    public void setX_coordinate_of_rider(double x_coordinate_of_rider) {
        this.x_coordinate_of_rider = x_coordinate_of_rider;
    }

    public double getY_coordinate_of_rider() {
        return y_coordinate_of_rider;
    }

    public void setY_coordinate_of_rider(double y_coordinate_of_rider) {
        this.y_coordinate_of_rider = y_coordinate_of_rider;
    }
}
