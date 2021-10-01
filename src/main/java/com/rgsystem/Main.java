package com.rgsystem;

import com.rgsystem.input.commandlineinputs.*;
import com.rgsystem.input.Inputs;
import com.rgsystem.input.InvalidInputException;

public class Main {
    public static void main(String[] args) {

        Inputs type = new ReportTypeInput(args);
        Inputs start = new StartDateInput(args);
        Inputs end = new EndDateInput(args);
        Inputs output = new OutputFormatInput(args);
        Inputs email = new UserMailInput(args);

        try {
            System.out.println(type.getReportRequirement());
            System.out.println(start.getReportRequirement());
            System.out.println(end.getReportRequirement());
            System.out.println(output.getReportRequirement());
            System.out.println(email.getReportRequirement());

        } catch (InvalidInputException e) {
            System.out.println("Error Occurred " + e.getMessage());
        }

    }
}
