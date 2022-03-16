package com.example.cronExpressionParser.services;

import com.example.cronExpressionParser.exceptions.OutOfRangeException;
import com.example.cronExpressionParser.exceptions.UnsupportedCharacterException;
import com.example.cronExpressionParser.exceptions.InvalidParameterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * author Arpita Saha
 */
public abstract class ExpressionParser {
    List<Character> allowedCharacters;
    int maxRange;
    int minRange;

    private void validateInput(String str) throws Exception {
        if (str == null || str.isEmpty()) throw new InvalidParameterException(this.getClass().getName());
        for (Character c : str.toCharArray()) {
            if (!allowedCharacters.contains(c) && !((c - '0') >= 0 && (c - '0') <= 9))
                throw new UnsupportedCharacterException(this.getClass().getName());
        }
    }

    public List<Integer> getParsedValue(String str) throws Exception {
        validateInput(str);
        List<Integer> values = new ArrayList<>();
        if (Pattern.matches("\\d+(,\\d+)*", str)) {
            values = Arrays.stream(str.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (Integer value : values) {
                if (value < minRange || value > maxRange)
                    throw new OutOfRangeException(this.getClass().getName());

            }

        } else if (Pattern.matches("\\d+-\\d+", str)) {

            List<Integer> valueRange = Arrays.stream(str.split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int startFrom = valueRange.get(0);
            int endTill = valueRange.get(1);
            if (
                    startFrom <= endTill &&
                    startFrom >= minRange && startFrom <= maxRange &&
                    endTill >= minRange && endTill <= maxRange
            ) {
                IntStream.rangeClosed(valueRange.get(0), valueRange.get(1)).forEach(values::add);
            } else throw new OutOfRangeException(this.getClass().getName());

        } else if (Pattern.matches("\\*", str)) {

            IntStream.rangeClosed(minRange, maxRange).forEach(values::add);

        } else if (Pattern.matches("\\*/\\d+", str)) {

            List<String> valueRange = Arrays.stream(str.split("/")).toList();
            int incrementBy = Integer.parseInt(valueRange.get(1));
            for (int i = minRange; i >= minRange && i <= maxRange; i += incrementBy) values.add(i);

        } else if (Pattern.matches("\\d+/\\d+", str)) {

            List<String> valueRange = Arrays.stream(str.split("/")).toList();
            int startFrom = Integer.parseInt(valueRange.get(0));
            int incrementBy = Integer.parseInt(valueRange.get(1));
            if(startFrom<minRange || startFrom >maxRange) throw new OutOfRangeException(this.getClass().getName());
            for (int i = startFrom; i >= minRange && i <= maxRange; i += incrementBy) values.add(i);

        } else {
            values = performAdditionalParsing(str);
        }
        return values;
    }

    abstract List<Integer> performAdditionalParsing(String str);

}
