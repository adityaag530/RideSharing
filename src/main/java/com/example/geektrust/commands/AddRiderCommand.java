package com.example.geektrust.commands;

import com.example.geektrust.entities.Rider;
import com.example.geektrust.services.IRiderService;

import java.util.List;

public class AddRiderCommand implements ICommand{

    private final IRiderService riderService;

    public AddRiderCommand(IRiderService riderService) {
        this.riderService = riderService;
    }

    @Override
    public void execute(List<String> tokens) {
        Rider rider = new Rider(tokens.get(0), Double.valueOf(tokens.get(1)), Double.valueOf(tokens.get(2)));
        riderService.addRider(rider);
    }
}
