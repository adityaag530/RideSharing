package com.example.geektrust.commands;

import com.example.geektrust.entities.Riding;
import com.example.geektrust.services.IMatchService;
import com.example.geektrust.services.IRiderService;

import java.util.List;

public class StartRideCommand implements ICommand{

    private final IRiderService riderService;
    private final IMatchService matchService;

    public StartRideCommand(IRiderService riderService, IMatchService matchService) {
        this.riderService = riderService;
        this.matchService = matchService;
    }

    @Override
    public void execute(List<String> tokens) {
        // START_RIDE RIDE-101 1 R1
        Riding riding = new Riding();
        riding.setRideId(tokens.get(0));
        riding.setDriverNo(Integer.valueOf(tokens.get(1)));
        riding.setRiderId(tokens.get(2));
        matchService.matchRider(tokens.get(2));
        riding.setRidingWithDriverId(riderService.findRider(tokens.get(2)).getDriversMatched().get(Integer.valueOf(tokens.get(1))-1).getDriverId());
        riderService.startRide(riding);

    }
}
