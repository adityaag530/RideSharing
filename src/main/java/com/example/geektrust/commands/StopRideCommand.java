package com.example.geektrust.commands;

import com.example.geektrust.entities.Rider;
import com.example.geektrust.services.IRiderService;
import sun.jvm.hotspot.utilities.IntegerEnum;

import java.util.List;

public class StopRideCommand implements ICommand{

    private final IRiderService riderService;

    public StopRideCommand(IRiderService riderService) {
        this.riderService = riderService;
    }
    @Override
    public void execute(List<String> tokens) {
        //STOP_RIDE RIDE-001 4 5 32
        Rider rider = riderService.findRiderByRidingId(tokens.get(0));
        if(rider!=null){
            rider.getRides().setRiding(false);
        }
        if(rider.getRides().isRiding()){
            System.out.println("RIDE_NOT_COMPLETED");
            return;
        }
        rider.getRides().setRiding(false);
        rider.getRides().setDropLocation(new int[]{Integer.valueOf(tokens.get(1)), Integer.valueOf(tokens.get(2))});
        rider.getRides().setTimeInMinutes(Integer.valueOf(tokens.get(3)));
        riderService.stopRide(rider);
    }
}
