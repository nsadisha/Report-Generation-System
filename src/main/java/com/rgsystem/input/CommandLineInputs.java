package com.rgsystem.input;

public class CommandLineInputs implements Inputs{

    private final String[] args;

    //Constructor of the class
    public CommandLineInputs(String[] arguments) {
        this.args = arguments;
    }

    public String getReportRequirement() throws InvalidInputException {

        //Make sure to validate the arguments before using...
        if (args.length == 0) {
            throw new InvalidInputException("Please provide the report details as an argument");
        }

        //open close principle violated here
        String reportType = args[0];
        if (!(reportType.equals("monthlysales") || reportType.equals("usersignups"))) {
            throw new InvalidInputException
                    ("Please provide monthlysales or usersignups as the report type for first argument");
        }

        String startTime = args[1];
        String endTime = args[2];
        String outputFormat = args[3];
        String userEmail = args[4];

        return reportType;
    }
}
