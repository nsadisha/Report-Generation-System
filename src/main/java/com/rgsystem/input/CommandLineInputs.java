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

        String reportType = args[0];
        //Make sure to validate the arguments before using...
        validations.validateReportType(reportType);
        return reportType;
    }

    @Override
    public String getStartDate() throws InvalidInputException {

        String startDate = args[1];

        //Make sure to validate the arguments before using...
        validations.validateDate(startDate);
        return startDate;
    }

    @Override
    public String getEndDate() throws InvalidInputException {

        String endDate = args[2];

        //Make sure to validate the arguments before using...
        validations.validateDate(endDate);
        return endDate;
    }

    @Override
    public String getOutputFormat() throws InvalidInputException {
        String outputFormat = args[3];

        //Make sure to validate the arguments before using...
        validations.validateOutputFormat(outputFormat);
        return outputFormat;
    }

    @Override
    public String getUserEmail() throws InvalidInputException {

        String userEmail = args[4];

        //Make sure to validate the arguments before using...
        validations.validateEmail(userEmail);
        return userEmail;

    }

}