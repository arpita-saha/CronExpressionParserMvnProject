package com.example.cronExpressionParser.services;

import java.util.ArrayList;
import java.util.List;

/**
 * author Arpita Saha
 */
public class MinuteParser extends ExpressionParser{
    static MinuteParser minuteParser;
    private MinuteParser(){
        minRange = 0;
        maxRange = 59;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }

    public static MinuteParser getInstance(){
        if(minuteParser == null){
            minuteParser = new MinuteParser();
        }
        return minuteParser;
    }

    @Override
    List<Integer> performAdditionalParsing(String str) {
        return new ArrayList<>();
    }
}
