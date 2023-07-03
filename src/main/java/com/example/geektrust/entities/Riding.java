package com.example.geektrust.entities;

public class Riding {
    private String rideId;
    private String riderId;

    private int driverNo;
    private String ridingWithDriverId;

    public String getRidingWithDriverId() {
        return ridingWithDriverId;
    }

    public void setRidingWithDriverId(String ridingWithDriverId) {
        this.ridingWithDriverId = ridingWithDriverId;
    }

    private boolean isRiding;

    private int[] dropLocation;

    private double bill;

    private int timeInMinutes;

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public int getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(int driverNo) {
        this.driverNo = driverNo;
    }

    public boolean isRiding() {
        return isRiding;
    }

    public void setRiding(boolean riding) {
        isRiding = riding;
    }

    public int[] getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(int[] dropLocation) {
        this.dropLocation = dropLocation;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
