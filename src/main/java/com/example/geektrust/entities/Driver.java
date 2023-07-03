package com.example.geektrust.entities;

public class Driver {
    private String driverId;
    private double x_coordinate_of_driver;
    private double y_coordinate_of_driver;

    public Driver(String driverId, double x_coordinate_of_driver, double y_coordinate_of_driver) {
        this.driverId = driverId;
        this.x_coordinate_of_driver = x_coordinate_of_driver;
        this.y_coordinate_of_driver = y_coordinate_of_driver;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public double getX_coordinate_of_driver() {
        return x_coordinate_of_driver;
    }

    public void setX_coordinate_of_driver(double x_coordinate_of_driver) {
        this.x_coordinate_of_driver = x_coordinate_of_driver;
    }

    public double getY_coordinate_of_driver() {
        return y_coordinate_of_driver;
    }

    public void setY_coordinate_of_driver(double y_coordinate_of_driver) {
        this.y_coordinate_of_driver = y_coordinate_of_driver;
    }
}
