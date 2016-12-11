package org.wahlzeit.exceptions;

public class NullArgumentException extends IllegalArgumentException {

    private String parameter;

    public NullArgumentException(String parameter) {
        super(parameter + " must not be null.");

        if (parameter == null) {
            throw new NullArgumentException("parameter");
        }

        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
