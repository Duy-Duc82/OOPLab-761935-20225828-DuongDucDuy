package hust.soict.hedspi.lab01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DaysInMonth {
    private static final Map<String, Integer> MONTHS = new HashMap<>();

    static {
        MONTHS.put("january", 1);
        MONTHS.put("jan", 1);
        MONTHS.put("1", 1);

        MONTHS.put("february", 2);
        MONTHS.put("feb", 2);
        MONTHS.put("2", 2);

        MONTHS.put("march", 3);
        MONTHS.put("mar", 3);
        MONTHS.put("3", 3);

        MONTHS.put("april", 4);
        MONTHS.put("apr", 4);
        MONTHS.put("4", 4);

        MONTHS.put("may", 5);
        MONTHS.put("5", 5);

        MONTHS.put("june", 6);
        MONTHS.put("jun", 6);
        MONTHS.put("6", 6);

        MONTHS.put("july", 7);
        MONTHS.put("jul", 7);
        MONTHS.put("7", 7);

        MONTHS.put("august", 8);
        MONTHS.put("aug", 8);
        MONTHS.put("8", 8);

        MONTHS.put("september", 9);
        MONTHS.put("sep", 9);
        MONTHS.put("sept", 9);
        MONTHS.put("9", 9);

        MONTHS.put("october", 10);
        MONTHS.put("oct", 10);
        MONTHS.put("10", 10);

        MONTHS.put("november", 11);
        MONTHS.put("nov", 11);
        MONTHS.put("11", 11);

        MONTHS.put("december", 12);
        MONTHS.put("dec", 12);
        MONTHS.put("12", 12);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int monthNumber = readMonthNumber(keyboard);
        int year = readYear(keyboard);

        int days = daysInMonth(monthNumber, year);
        System.out.println("Number of days: " + days);

        keyboard.close();
    }

    private static int readMonthNumber(Scanner keyboard) {
        while (true) {
            System.out.print("Enter month (name, 3-letter, or number): ");
            String input = keyboard.nextLine().trim().toLowerCase();

            Integer month = MONTHS.get(input);
            if (month != null) {
                return month;
            }
            System.out.println("Invalid month. Please try again.");
        }
    }

    private static int readYear(Scanner keyboard) {
        while (true) {
            System.out.print("Enter year (non-negative, digits only): ");
            String input = keyboard.nextLine().trim();

            if (!input.matches("\\d+")) {
                System.out.println("Invalid year. Please try again.");
                continue;
            }

            try {
                int year = Integer.parseInt(input);
                if (year >= 0) {
                    return year;
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Invalid year. Please try again.");
        }
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }
}

