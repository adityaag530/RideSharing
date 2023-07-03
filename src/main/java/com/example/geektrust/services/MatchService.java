package com.example.geektrust.services;

import com.example.geektrust.entities.Driver;
import com.example.geektrust.entities.Rider;
import com.example.geektrust.repositories.IDriverRepository;
import com.example.geektrust.repositories.IRiderRepository;

import java.util.*;

public class MatchService implements IMatchService{

    private final IRiderRepository riderRepository;
    private final IDriverRepository driverRepository;

    public MatchService(IRiderRepository riderRepository, IDriverRepository driverRepository) {
        this.riderRepository = riderRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    public void matchRider(String riderId) {
        Rider rider = riderRepository.findByRiderId(riderId);
        List<Driver> drivers = driverRepository.findAll();
        List<String[]> topDrivers = new ArrayList<>();
        for(Driver d: drivers){
            topDrivers.add( findNearestDriver(rider, d) );
        }
        topDrivers.sort( Comparator.comparingDouble(  a -> Double.parseDouble(a[0]) ) );
        StringBuilder driverMatched = new StringBuilder("DRIVERS_MATCHED");
        for(String[] s: topDrivers){
            if(Double.parseDouble( s[0])<5 ){
                driverMatched.append(" ").append(s[1]);
            }
        }
        if(driverMatched.equals("DRIVERS_MATCHED")){
            System.out.println("NO_DRIVER_AVAILABLE");
        }else{
            System.out.println(driverMatched);
            List<Driver> driversNearRider = new ArrayList<>();
            for(String[] s: topDrivers){
                driversNearRider.add(driverRepository.findDriverById(s[1]));
            }
            rider.setDriversMatched(driversNearRider);
        }
    }

    public String[] findNearestDriver(Rider rider, Driver driver){
        String[] driverDistancePair = new String[2];
        driverDistancePair[1] = String.valueOf(driver.getDriverId());
        double diff_of_x = rider.getX_coordinate_of_rider() - driver.getX_coordinate_of_driver();
        double diff_of_y = rider.getY_coordinate_of_rider() - driver.getY_coordinate_of_driver();
        driverDistancePair[0] = String.valueOf(findDistance(diff_of_x, diff_of_y));
        return driverDistancePair;
    }

    public double findDistance(double diffOfX, double diffOfY){
        return Math.round( Math.sqrt( (diffOfX * diffOfX) + (diffOfY * diffOfY) ) * 100)/100.0;
    }
}
