package com.example.geektrust.commands;

import com.example.geektrust.services.IMatchService;
import com.example.geektrust.services.IRiderService;

import java.util.List;

public class MatchRiderCommand implements ICommand{

    private final IMatchService matchService;


    public MatchRiderCommand(IMatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public void execute(List<String> tokens) {
        matchService.matchRider(tokens.get(0));
        matchService.printMatchedDriver();
    }
}
