package com.rgsystem.validation;

import com.rgsystem.input.InvalidInputException;

public class CMDInputValidations implements InputValidations{

    @Override
    public void validateReportType(String reportType) throws InvalidInputException {

        if (reportType == null) {
            throw new InvalidInputException("Please provide the report type");

        }else (!(reportType.equals("daily-sales") || reportType.equals("user-signups"))) {
            throw new InvalidInputException
                    ("Please provide daily-sales or user-signups as the report type for first argument");
        }
    }

    @Override
    public void validateDate(String date) throws InvalidInputException {

        if (date == null) {
            throw new InvalidInputException("Please provide the start and end dates");
        }else (!(date.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})"))){
            throw new InvalidInputException("Please provide the  date in dd/mm/yyyy format");
        }

    }

    @Override
    public void validateOutputFormat() throws InvalidInputException {
        return null;
    }

    @Override
    public void validateEmail() throws InvalidInputException {
        return null;
    }
}
