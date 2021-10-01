package com.rgsystem.input.commandlineinputs;

import com.rgsystem.input.Inputs;

public abstract class CommandLineInputs implements Inputs {

    protected final String[] args;

    protected CommandLineInputs(String[] args) {
        this.args = args;
    }

}
