package com.example.geektrust;

import com.example.geektrust.appConfig.ApplicationConfig;
import com.example.geektrust.commands.CommandInvoker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);

            ApplicationConfig applicationConfig = new ApplicationConfig();
            CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens.subList(1,tokens.size()));
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
