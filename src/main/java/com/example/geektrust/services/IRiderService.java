package com.example.geektrust.services;

import com.example.geektrust.entities.Rider;
import com.example.geektrust.entities.Riding;

public interface IRiderService {
    void addRider(Rider rider);
    Rider findRider(String riderId);

    void startRide(Riding riding);

    void stopRide(Rider rider);

    Rider findRiderByRidingId(String s);
}
