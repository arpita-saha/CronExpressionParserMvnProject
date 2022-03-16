package com.example.cronExpressionParser.model;


import com.example.cronExpressionParser.services.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author Arpita Saha
 */
public class CronExpression {
    List<Integer> minutes;
    List<Integer> hours;
    List<Integer> days;
    List<Integer> months;
    List<Integer> weekDays;
    String command;


    public CronExpression() {
        this.minutes = new ArrayList<>();
        this.hours = new ArrayList<>();
        this.days = new ArrayList<>();
        this.months = new ArrayList<>();
        this.weekDays = new ArrayList<>();
        this.command = "";
    }

    public void printExpression() {
        if (!minutes.isEmpty()) {
            System.out.print("minute       :");
            minutes.forEach((Integer minute) -> System.out.print(" " + minute));
        }
        System.out.println();
        if (!hours.isEmpty()) {
            System.out.print("hour         :");
            hours.forEach((Integer hour) -> System.out.print(" " + hour));
            System.out.println();
        }

        if (!days.isEmpty()) {
            System.out.print("day of month :");
            days.forEach((Integer day) -> System.out.print(" " + day));
            System.out.println();
        }

        if (!months.isEmpty()) {
            System.out.print("month        :");
            months.forEach((Integer month) -> System.out.print(" " + month));
            System.out.println();
        }

        if (!weekDays.isEmpty()) {
            System.out.print("day of week  :");
            weekDays.forEach((Integer week) -> System.out.print(" " + week));
            System.out.println();
        }

        if (!command.isEmpty()) {
            System.out.print("command      :");
            System.out.println(command);
        }
    }

    public List<Integer> getMinutes() {
        return minutes;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public List<Integer> getDays() {
        return days;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public List<Integer> getWeekDays() {
        return weekDays;
    }

    public String getCommand() {
        return command;
    }

    public void setMinutes(List<Integer> minutes) {
        this.minutes = minutes;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    public void setWeekDays(List<Integer> weekDays) {
        this.weekDays = weekDays;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
