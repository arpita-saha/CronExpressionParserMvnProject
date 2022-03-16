package com.example.cronExpressionParser;

import com.example.cronExpressionParser.model.CronExpression;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CronExpressionParserApplication {

    public static void main(String[] args) {
//        String expression = "1/15 0 1,15 * 1-5 /usr/bin/find";
        try {
            handleInput();
        } catch (IOException ex) {
            System.out.println("Something went wrong. Please try again!");
        }
    }

    public static void handleInput() throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("Enter expression to be parsed or enter exit : ");
                String inputLine = inputReader.readLine();
                if (inputLine == null) {
                    break;
                }

                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) {
                    continue;
                }

                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                processInputLine(inputLine);
            }
        } finally {
            inputReader.close();
        }
    }

    public static void processInputLine(String expression) {
        CronExpressionParser cronExpressionParser = CronExpressionParser.getInstance();
        CronExpression cronExpression = cronExpressionParser.getCronExpression(expression);
        if (cronExpression != null) cronExpression.printExpression();
        else System.out.println("Cron expression is not found");
    }
}
