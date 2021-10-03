package com.rgsystem.validation;

import com.rgsystem.input.InvalidInputException;

public interface InputValidations {

    void validateReportType(String reportType) throws InvalidInputException;
    void validateDate(String date) throws InvalidInputException;
    void validateOutputFormat(String outputFormat) throws InvalidInputException;
    void validateEmail(String email) throws InvalidInputException;

}
