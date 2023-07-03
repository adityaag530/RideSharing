package com.example.geektrust.commands;

import com.example.geektrust.entities.Rider;
import com.example.geektrust.services.IRiderService;

import java.util.List;

public class BillGenerateCommand implements ICommand{

    private final IRiderService riderService;

    public BillGenerateCommand(IRiderService riderService) {
        this.riderService = riderService;
    }

    @Override
    public void execute(List<String> tokens) {
//        BILL RIDE-001 D3 186.72
        Rider rider = riderService.findRiderByRidingId(tokens.get(0));
        System.out.println("BILL " + rider.getRides().getRideId() + " " + rider.getRides().getRidingWithDriverId() + " " + rider.getRides().getBill());
    }
}
