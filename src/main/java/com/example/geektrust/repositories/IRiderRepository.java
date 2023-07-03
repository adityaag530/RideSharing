package com.example.geektrust.repositories;

import com.example.geektrust.entities.Rider;

public interface IRiderRepository {

    void addRider(Rider rider);
    Rider findByRiderId(String riderId);

    Rider findByRidingId(String s);
}
