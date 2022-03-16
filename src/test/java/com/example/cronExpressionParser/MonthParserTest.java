package com.example.cronExpressionParser;

import com.example.cronExpressionParser.exceptions.InvalidParameterException;
import com.example.cronExpressionParser.exceptions.OutOfRangeException;
import com.example.cronExpressionParser.exceptions.UnsupportedCharacterException;
import com.example.cronExpressionParser.services.MonthParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MonthParserTest {

    MonthParser monthParser;

    @BeforeEach
    public void setUp(){
        monthParser = monthParser.getInstance();
    }

    @Test
    public void getParsedValue_whenValidInput_shouldNotThrowException() throws Exception {
        String expression = "1,12";
        monthParser.getParsedValue(expression);
    }

    @Test
    public void getParsedValue_whenValidExpressionInput_shouldReturnList() throws Exception {
        List<Integer> days = monthParser.getParsedValue("1,10");
        Assertions.assertTrue(days.size() == 2);
    }

    @Test
    public void getParsedValue_whenEmptyInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> { monthParser.getParsedValue(null);});
        Assertions.assertTrue(exception.getMessage().contains(monthParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                UnsupportedCharacterException.class,
                () -> { monthParser.getParsedValue("1,#15");});
        Assertions.assertTrue(exception.getMessage().contains(monthParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidCommaSeparatedNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { monthParser.getParsedValue("6,15");});
        Assertions.assertTrue(exception.getMessage().contains(monthParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidRangeNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { monthParser.getParsedValue("5-20");});
        Assertions.assertTrue(exception.getMessage().contains(monthParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidStartNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { monthParser.getParsedValue("20/15");});
        Assertions.assertTrue(exception.getMessage().contains(monthParser.getClass().getName()));
    }
}
