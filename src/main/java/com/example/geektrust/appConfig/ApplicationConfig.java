package com.example.geektrust.appConfig;

import com.example.geektrust.commands.*;
import com.example.geektrust.repositories.DriverRepository;
import com.example.geektrust.repositories.IDriverRepository;
import com.example.geektrust.repositories.IRiderRepository;
import com.example.geektrust.repositories.RiderRepository;
import com.example.geektrust.services.*;
import com.example.geektrust.services.IDriverService;

public class ApplicationConfig {
    IRiderRepository riderRepository = new RiderRepository();
    IDriverRepository driverRepository = new DriverRepository();

    IRiderService riderService = new RiderService(riderRepository);
    IDriverService driverService = new DriverService(driverRepository);
    IMatchService matchService = new MatchService(riderRepository, driverRepository);

    ICommand addRiderCommand = new AddRiderCommand(riderService);
    ICommand addDriverCommand = new AddDriverCommand(driverService);
    ICommand matchRiderCommand = new MatchRiderCommand(matchService);

    ICommand startRideCommand = new StartRideCommand(riderService, matchService);
    ICommand stopRideCommand = new StopRideCommand(riderService);
    ICommand billGenerateCommand = new BillGenerateCommand(riderService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ADD_DRIVER",addDriverCommand);
        commandInvoker.register("ADD_RIDER",addRiderCommand);
        commandInvoker.register("MATCH", matchRiderCommand);
        commandInvoker.register("START_RIDE", startRideCommand);
        commandInvoker.register("STOP_RIDE", stopRideCommand);
        commandInvoker.register("BILL", billGenerateCommand);


        return commandInvoker;
    }
}
