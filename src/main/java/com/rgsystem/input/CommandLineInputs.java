package com.rgsystem.input;

public class CommandLineInputs implements Inputs {

    private final String[] args;

    public CommandLineInputs(String[] args) {
        this.args = args;
    }

    @Override
    public String getReportType() throws InvalidInputException {

        String reportType = args[0];
        //Make sure to validate the arguments before using...
        if (reportType == null) {
            throw new InvalidInputException("Please provide the report type as an argument");
        }

        if (!(reportType.equals("monthlysales") || reportType.equals("usersignups"))) {
            throw new InvalidInputException
                    ("Please provide monthlysales or usersignups as the report type for first argument");
        }
        return reportType;
    }

    @Override
    public String getStartDate() throws InvalidInputException {

        String startDate = args[1];

        //Make sure to validate the arguments before using...
        if (startDate == null) {
            throw new InvalidInputException("Please provide the start date as the second argument");
        }

        /*if(!(isDateValid(startDate))){
            throw new InvalidInputException("Please provide the start date in dd/mm/yyyy format");
        } */

        return startDate;
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
