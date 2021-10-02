package com.rgsystem.input;

public interface Inputs {

    String getReportType() throws InvalidInputException;
    String getStartDate() throws InvalidInputException;
    String getEndDate() throws InvalidInputException;
    String getOutputFormat() throws InvalidInputException;
    String getUserEmail() throws InvalidInputException;

}