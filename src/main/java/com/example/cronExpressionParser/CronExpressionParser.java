package com.example.cronExpressionParser;

import com.example.cronExpressionParser.exceptions.InvalidParameterException;
import com.example.cronExpressionParser.model.CronExpression;
import com.example.cronExpressionParser.services.*;

import java.util.Arrays;
import java.util.List;

public class CronExpressionParser {
    private static CronExpressionParser cronExpressionParser;

    ExpressionParser minuteParser, hourParser, dayParser, monthParser, weekDayParser;

    private CronExpressionParser() {
        this.minuteParser = MinuteParser.getInstance();
        this.hourParser = HourParser.getInstance();
        this.dayParser = DayParser.getInstance();
        this.monthParser = MonthParser.getInstance();
        this.weekDayParser = WeekDayParser.getInstance();
    }

    public static CronExpressionParser getInstance() {
        if (cronExpressionParser == null) {
            cronExpressionParser = new CronExpressionParser();
        }
        return cronExpressionParser;
    }

    public CronExpression getCronExpression(String expression) {
        CronExpression cronExpression = new CronExpression();
        try {
            List<String> expressionList = Arrays.stream(expression.split(" ")).toList();
            if (expressionList.size() != 6) throw new InvalidParameterException(this.getClass().getName());
            cronExpression.setMinutes(decodeAndGetMinutes(expressionList.get(0)));
            cronExpression.setHours(decodeAndGetHours(expressionList.get(1)));
            cronExpression.setDays(decodeAndGetDays(expressionList.get(2)));
            cronExpression.setMonths(decodeAndGetMonths(expressionList.get(3)));
            cronExpression.setWeekDays(decodeAndGetWeekDay(expressionList.get(4)));
            cronExpression.setCommand(expressionList.get(5));
        } catch (Exception e) {
            System.out.println(String.format("Unable to proceed further, got an exception :\n%s", e.getMessage()));
            return null;
        }
        return cronExpression;
    }

    private List<Integer> decodeAndGetMinutes(String minuteExpression) throws Exception {
        System.out.println("Parsing minutes expression : " + minuteExpression);
        return minuteParser.getParsedValue(minuteExpression);
    }

    private List<Integer> decodeAndGetHours(String hourExpression) throws Exception {
        System.out.println("Parsing hours expression : " + hourExpression);
        return hourParser.getParsedValue(hourExpression);
    }

    private List<Integer> decodeAndGetDays(String dayExpression) throws Exception {
        System.out.println("Parsing day expression : " + dayExpression);
        return dayParser.getParsedValue(dayExpression);
    }

    private List<Integer> decodeAndGetMonths(String monthExpression) throws Exception {
        System.out.println("Parsing month expression : " + monthExpression);
        return monthParser.getParsedValue(monthExpression);
    }

    private List<Integer> decodeAndGetWeekDay(String weekDayExpression) throws Exception {
        System.out.println("Parsing minutes expression : " + weekDayExpression);
        return weekDayParser.getParsedValue(weekDayExpression);
    }
}
