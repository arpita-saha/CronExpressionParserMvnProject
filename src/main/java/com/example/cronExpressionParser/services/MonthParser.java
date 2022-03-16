package com.example.cronExpressionParser.services;

import java.util.ArrayList;
import java.util.List;

/**
 * author Arpita Saha
 */
public class MonthParser extends ExpressionParser {
    private static MonthParser monthParser;
    private MonthParser(){
        minRange = 1;
        maxRange = 12;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }

    public static MonthParser getInstance(){
        if(monthParser == null){
            monthParser = new MonthParser();
        }
        return monthParser;
    }

    @Override
    List<Integer> performAdditionalParsing(String str) {
        return new ArrayList<>();
    }
}
