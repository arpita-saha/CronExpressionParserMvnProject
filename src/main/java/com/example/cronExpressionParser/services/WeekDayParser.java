package com.example.cronExpressionParser.services;

import java.util.ArrayList;
import java.util.List;
/**
 * author Arpita Saha
 */
public class WeekDayParser extends ExpressionParser{

    private static WeekDayParser weekDayParser;
    private WeekDayParser(){
        minRange = 1;
        maxRange = 7;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }

    public static WeekDayParser getInstance(){
        if(weekDayParser == null){
            weekDayParser = new WeekDayParser();
        }
        return weekDayParser;
    }

    @Override
    List<Integer> performAdditionalParsing(String str) {
        return new ArrayList<>();
    }
}
