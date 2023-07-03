package com.example.geektrust.commands;

import com.example.geektrust.entities.Driver;
import com.example.geektrust.services.IDriverService;

import java.util.List;

public class AddDriverCommand implements ICommand{
    private final IDriverService driverService;

    public AddDriverCommand(IDriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public void execute(List<String> tokens) {
        Driver driver = new Driver(tokens.get(0), Double.valueOf(tokens.get(1)), Double.valueOf(tokens.get(2)));
        driverService.addDriver(driver);
    }
}
