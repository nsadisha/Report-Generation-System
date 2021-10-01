package com.rgsystem.input.CommandLineInputs;

import com.rgsystem.input.InvalidInputException;

public class OutputFormatInput extends CommandLineInputs{

    private final String outputFormat;

    //Constructor of the class
    public OutputFormatInput(String[] args) {
        super(args);
        outputFormat = this.args[3];
    }


    public String getReportRequirement() throws InvalidInputException {

        //Make sure to validate the arguments before using...
        if (outputFormat == null) {
            throw new InvalidInputException("Please provide the report type as an argument");
        }

        if (!(outputFormat.equals("email") || outputFormat.equals("file"))) {
            throw new InvalidInputException
                    ("Please provide mail or file as the report output format for fourth argument");
        }

        return outputFormat;
    }

}
