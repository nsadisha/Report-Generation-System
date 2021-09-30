package com.rgsystem;

import com.rgsystem.input.CommandLineInputs;
import com.rgsystem.input.Inputs;
import com.rgsystem.input.InvalidInputException;

public class Main {
    public static void main(String[] args) {

        Inputs inputs = new CommandLineInputs(args);

        try {
            String reportType = inputs.getReportRequirement();
            System.out.println(reportType);
        } catch (InvalidInputException e) {
            System.out.println("Error Occurred " + e.getMessage());
        }

    }
}
