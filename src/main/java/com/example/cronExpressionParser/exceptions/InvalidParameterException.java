package com.example.cronExpressionParser.exceptions;

public class InvalidParameterException extends Exception {

    public InvalidParameterException(String message) {
        super(String.format("Invalid parameter is passed to %s class", message));
    }
}

