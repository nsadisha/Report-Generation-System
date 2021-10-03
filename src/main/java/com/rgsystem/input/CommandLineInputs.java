package com.rgsystem.input;

import com.rgsystem.validation.InputValidations;

public class CommandLineInputs implements Inputs {

    private final String[] args;
    private final InputValidations validations;

    public CommandLineInputs(String[] args, InputValidations validations) {
        this.args = args;
        this.validations = validations;
    }

    @Override
    public String getReportType() throws InvalidInputException {

        //Make sure to validate the arguments before using...
        validations.validateReportType();
        return args[0];
    }

    @Override
    public String getStartDate() throws InvalidInputException {

        String startDate = args[1];

        //Make sure to validate the arguments before using...

        return args[1];
    }

    @Override
    public String getEndDate() throws InvalidInputException {

        String endDate = args[2];

        //Make sure to validate the arguments before using...
        if (endDate == null) {
            throw new InvalidInputException("Please provide the end date as the third argument");
        }

        /*if(!(isDateValid(endDate))){
            throw new InvalidInputException("Please provide the end date in dd/mm/yyyy format");
        }*/

        return endDate;
    }

    @Override
    public String getOutputFormat() throws InvalidInputException {
        String outputFormat = args[3];

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

    @Override
    public String getUserEmail() throws InvalidInputException {

        String userEmail = args[4];

        //Make sure to validate the arguments before using...
        if (userEmail == null) {
            throw new InvalidInputException("Please provide the user email as the fifth argument");
        }

        /*if(!(isEmailValid(userEmail))){
            throw new InvalidInputException("Please provide a valid user email as the fifth argument");
        }*/

        return userEmail;

    }

}