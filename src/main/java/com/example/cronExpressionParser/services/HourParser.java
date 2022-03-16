package com.example.cronExpressionParser.services;

import java.util.ArrayList;
import java.util.List;

/**
 * author Arpita Saha
 */
public class HourParser extends ExpressionParser {

    private static HourParser hourParser;

    private HourParser() {
        minRange = 0;
        maxRange = 23;
        allowedCharacters = new ArrayList<>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }

    public static HourParser getInstance() {
        if (hourParser == null) {
            hourParser = new HourParser();
        }
        return hourParser;
    }

    @Override
    List<Integer> performAdditionalParsing(String str) {
        return new ArrayList<>();
    }
}
