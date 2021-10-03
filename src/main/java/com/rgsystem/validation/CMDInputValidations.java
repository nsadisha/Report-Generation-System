package com.rgsystem.validation;

import com.rgsystem.input.InvalidInputException;

public class CMDInputValidations implements InputValidations{

    @Override
    public void validateReportType(String reportType) throws InvalidInputException {

        if (reportType == null) {
            throw new InvalidInputException("Please provide the report type");

        }else if (!(reportType.equals("daily-sales") || reportType.equals("user-signups"))){
            throw new InvalidInputException
                    ("Please provide daily-sales or user-signups as the report type for first argument");
        }
    }

    @Override
    public void validateDate(String date) throws InvalidInputException {

        if (date == null) {
            throw new InvalidInputException("Please provide the start and end dates");
        }else if (!(date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"))){
            throw new InvalidInputException("Please provide the  date in dd/mm/yyyy format");
        }

    }

    @Override
    public void validateOutputFormat(String outputFormat) throws InvalidInputException {
        if (outputFormat == null) {
            throw new InvalidInputException("Please provide the report type as an argument");
        }else if(!(outputFormat.equals("email") || outputFormat.equals("file"))) {
            throw new InvalidInputException
                    ("Please provide mail or file as the report output format for fourth argument");
        }
    }

    @Override
    public void validateEmail(String email) throws InvalidInputException {

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        if (email == null) {
            throw new InvalidInputException("Please provide the user email as the fifth argument");
        }else  if(!(email.matches(regex))){
            throw new InvalidInputException("Please provide a valid user email as the fifth argument");
        }
    }
}
