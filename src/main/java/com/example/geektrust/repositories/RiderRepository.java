package com.example.geektrust.repositories;

import com.example.geektrust.entities.Driver;
import com.example.geektrust.entities.Rider;
import java.util.ArrayList;
import java.util.List;

public class RiderRepository implements IRiderRepository{
    private final List<Rider> riders = new ArrayList<>();


    @Override
    public void addRider(Rider rider) {
        riders.add(rider);
//        System.out.println("Rider Added Successfully!");
    }

    @Override
    public Rider findByRiderId(String riderId) {
        for(Rider r: riders){
            if(riderId.equals( r.getRiderId()) ){
                return r;
            }
        }
        return null;
    }

    @Override
    public Rider findByRidingId(String s) {
        for(Rider r: riders){
            if(s.equals(r.getRides().getRideId())){
                return r;
            }
        }
        return null;
    }

}
