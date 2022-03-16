package com.example.cronExpressionParser;

import com.example.cronExpressionParser.exceptions.InvalidParameterException;
import com.example.cronExpressionParser.exceptions.OutOfRangeException;
import com.example.cronExpressionParser.exceptions.UnsupportedCharacterException;
import com.example.cronExpressionParser.services.DayParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class DayParserTest {

    DayParser dayParser;

    @BeforeEach
    public void setUp(){
        dayParser = DayParser.getInstance();
    }

    @Test
    public void getParsedValue_whenValidInput_shouldNotThrowException() throws Exception {
        String expression = "1,15";
        dayParser.getParsedValue(expression);
    }

    @Test
    public void getParsedValue_whenValidExpressionInput_shouldReturnList() throws Exception {
        List<Integer> days = dayParser.getParsedValue("1,15");
        Assertions.assertTrue(days.size() == 2);
    }

    @Test
    public void getParsedValue_whenEmptyInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                InvalidParameterException.class,
                () -> { dayParser.getParsedValue(null);});
        Assertions.assertTrue(exception.getMessage().contains(dayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                UnsupportedCharacterException.class,
                () -> { dayParser.getParsedValue("1,#15");});
        Assertions.assertTrue(exception.getMessage().contains(dayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidCommaSeparatedNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { dayParser.getParsedValue("167,15");});
        Assertions.assertTrue(exception.getMessage().contains(dayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidRangeNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { dayParser.getParsedValue("20-15");});
        Assertions.assertTrue(exception.getMessage().contains(dayParser.getClass().getName()));
    }

    @Test
    public void getParsedValue_whenInvalidStartNoExpressionInput_shouldThrowException() throws Exception {
        Exception exception = Assertions.assertThrows(
                OutOfRangeException.class,
                () -> { dayParser.getParsedValue("37/15");});
        Assertions.assertTrue(exception.getMessage().contains(dayParser.getClass().getName()));
    }
}
