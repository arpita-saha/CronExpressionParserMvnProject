package com.example.cronExpressionParser;

import com.example.cronExpressionParser.exceptions.InvalidParameterException;
import com.example.cronExpressionParser.exceptions.OutOfRangeException;
import com.example.cronExpressionParser.exceptions.UnsupportedCharacterException;
import com.example.cronExpressionParser.services.WeekDayParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class WeekDayParserTest {

    WeekDayParser weekDayParser;

    @BeforeEach
    public void setUp(){
        weekDayParser = weekDayParser.getInstance();
    }

    @Test
    public void getParsedValue_whenValidInput_shouldNotThrowException() throws Exception {
        String expression = "1,6";
        weekDayParser.getParsedValue(expression);
    }

    @Test
    public void getParsedValue_whenValidExpressionInput_shouldReturnList() throws Exception {
        List<Integer> days = weekDayParser.getParsedValue("1,5");
        Assertions.assertTrue(days.size() == 2);
    }

    @Test
    public void getParsedValue_whenEmptyInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> { weekDayParser.getParsedValue(null);});
        Assertions.assertTrue(exception.getMessage().contains(weekDayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                UnsupportedCharacterException.class,
                () -> { weekDayParser.getParsedValue("1,#15");});
        Assertions.assertTrue(exception.getMessage().contains(weekDayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidCommaSeparatedNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { weekDayParser.getParsedValue("6,8");});
        Assertions.assertTrue(exception.getMessage().contains(weekDayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidRangeNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { weekDayParser.getParsedValue("5-9");});
        Assertions.assertTrue(exception.getMessage().contains(weekDayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidStartNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { weekDayParser.getParsedValue("8/15");});
        Assertions.assertTrue(exception.getMessage().contains(weekDayParser.getClass().getName()));
    }
}
