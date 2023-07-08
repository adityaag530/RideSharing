package com.example.geektrust.services;

import com.example.geektrust.entities.Rider;
import com.example.geektrust.entities.Riding;
import com.example.geektrust.repositories.IRiderRepository;

import static com.example.geektrust.constants.Constant.*;

public class RiderService implements IRiderService{
    @Override
    public Rider findRiderByRidingId(String s) {
        return riderRepository.findByRidingId(s);
    }

    private final IRiderRepository riderRepository;

    public RiderService(IRiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public void addRider(Rider rider) {
        riderRepository.addRider(rider);
    }

    @Override
    public Rider findRider(String riderId) {
        return riderRepository.findByRiderId(riderId);
    }

    public void startRide(Riding riding){
//        System.out.println("Ride started");
        riding.setRiding(true);
        riderRepository.findByRiderId(riding.getRiderId()).setRides(riding);
        System.out.println("RIDE_STARTED " + riding.getRideId());
    }

    public void stopRide(Rider rider){
        rider.getRides().setRiding(false);
        calculatePrice(rider);
        System.out.println("RIDE_STOPPED " + rider.getRides().getRideId());
//        System.out.println("ride stopped");
    }

    public void calculatePrice(Rider rider){
//        A base fare of ₹50 is charged for every ride.
//        An additional ₹6.5 is charged for every kilometer traveled.
//                An additional ₹2 is charged for every minute spent in the ride.
//        A service tax of 20% is added to the final amount.

        double bill;
        bill = BASE_FARE + PER_KM_RATE * calculateDistance(rider) + PER_MIN_RATE * rider.getRides().getTimeInMinutes();
        bill = bill + bill * SERVICE_TAX;
        rider.getRides().setBill(bill);
    }

    public double calculateDistance(Rider rider){
        double distance = Math.round(
                Math.sqrt(
                        Math.pow(rider.getX_coordinate_of_rider() - rider.getRides().getDropLocation()[0], PER_MIN_RATE) + Math.pow(rider.getY_coordinate_of_rider() - rider.getRides().getDropLocation()[1], PER_MIN_RATE)
                ) * HUNDRED) / HUNDRED;
        return distance;
    }

}
