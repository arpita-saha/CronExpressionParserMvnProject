package com.example.cronExpressionParser.exceptions;

public class UnsupportedCharacterException extends Exception{
    public UnsupportedCharacterException(String message) {
        super(String.format("Characters in expression is not supported by %s parser", message));
    }
}
