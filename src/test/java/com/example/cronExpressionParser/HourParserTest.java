package com.example.cronExpressionParser;

import com.example.cronExpressionParser.exceptions.InvalidParameterException;
import com.example.cronExpressionParser.exceptions.OutOfRangeException;
import com.example.cronExpressionParser.exceptions.UnsupportedCharacterException;
import com.example.cronExpressionParser.services.HourParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class HourParserTest {

    HourParser hourParser;

    @BeforeEach
    public void setUp(){
        hourParser = HourParser.getInstance();
    }

    @Test
    public void getParsedValue_whenValidInput_shouldNotThrowException() throws Exception {
        String expression = "1,15";
        hourParser.getParsedValue(expression);
    }

    @Test
    public void getParsedValue_whenValidExpressionInput_shouldReturnList() throws Exception {
        List<Integer> days = hourParser.getParsedValue("1,15");
        Assertions.assertTrue(days.size() == 2);
    }

    @Test
    public void getParsedValue_whenEmptyInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> { hourParser.getParsedValue(null);});
        Assertions.assertTrue(exception.getMessage().contains(hourParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                UnsupportedCharacterException.class,
                () -> { hourParser.getParsedValue("1,#15");});
        Assertions.assertTrue(exception.getMessage().contains(hourParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidCommaSeparatedNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { hourParser.getParsedValue("26,15");});
        Assertions.assertTrue(exception.getMessage().contains(hourParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidRangeNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { hourParser.getParsedValue("5-28");});
        Assertions.assertTrue(exception.getMessage().contains(hourParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidStartNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { hourParser.getParsedValue("26/15");});
        Assertions.assertTrue(exception.getMessage().contains(hourParser.getClass().getName()));
    }
}
