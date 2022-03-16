package com.example.cronExpressionParser;

import com.example.cronExpressionParser.exceptions.InvalidParameterException;
import com.example.cronExpressionParser.exceptions.OutOfRangeException;
import com.example.cronExpressionParser.exceptions.UnsupportedCharacterException;
import com.example.cronExpressionParser.services.MinuteParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MinuteParserTest {

    MinuteParser minuteParser;

    @BeforeEach
    public void setUp(){
        minuteParser = minuteParser.getInstance();
    }

    @Test
    public void getParsedValue_whenValidInput_shouldNotThrowException() throws Exception {
        String expression = "1,15";
        minuteParser.getParsedValue(expression);
    }

    @Test
    public void getParsedValue_whenValidExpressionInput_shouldReturnList() throws Exception {
        List<Integer> days = minuteParser.getParsedValue("1,15");
        Assertions.assertTrue(days.size() == 2);
    }

    @Test
    public void getParsedValue_whenEmptyInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> { minuteParser.getParsedValue(null);});
        Assertions.assertTrue(exception.getMessage().contains(minuteParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                UnsupportedCharacterException.class,
                () -> { minuteParser.getParsedValue("1,#15");});
        Assertions.assertTrue(exception.getMessage().contains(minuteParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidCommaSeparatedNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { minuteParser.getParsedValue("67,15");});
        Assertions.assertTrue(exception.getMessage().contains(minuteParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidRangeNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { minuteParser.getParsedValue("5-67");});
        Assertions.assertTrue(exception.getMessage().contains(minuteParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidStartNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { minuteParser.getParsedValue("67/15");});
        Assertions.assertTrue(exception.getMessage().contains(minuteParser.getClass().getName()));
    }
}
