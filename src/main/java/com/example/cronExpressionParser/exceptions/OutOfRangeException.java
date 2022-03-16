package com.example.cronExpressionParser.exceptions;

public class OutOfRangeException extends Exception{
    public OutOfRangeException(String message) {
        super(String.format("Number is expression is out of range for %s parser", message));
    }
}
