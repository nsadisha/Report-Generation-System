package com.rgsystem.input.CommandLineInputs;

import com.rgsystem.input.InvalidInputException;

public class UserMailInput extends CommandLineInputs {

    private final String userEmail;

    //Constructor of the class
    public UserMailInput(String[] args) {
        super(args);
        userEmail = this.args[4];
    }


    public String getReportRequirement() throws InvalidInputException {

        //Make sure to validate the arguments before using...
        if (userEmail == null) {
            throw new InvalidInputException("Please provide the user email as the fifth argument");
        }

        return userEmail;
    }

}
