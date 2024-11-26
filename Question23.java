package Java.Class12;

import java.util.Scanner;

import java.util.Scanner;

public class Question23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the input date and the day of 1st January
        System.out.print("Enter the date (dd/mm/yyyy): ");
        String dateInput = scanner.nextLine();
        System.out.print("Enter the day on 1st January: ");
        String firstDayOfYear = scanner.nextLine().toUpperCase();

        // Validate the inputs
        if (!isValidDate(dateInput) || !isValidDay(firstDayOfYear)) {
            System.out.println("Invalid input! Please check the date or the day.");
            return;
        }

        // Parse the date input
        String[] dateParts = dateInput.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        // Find the day for the input date
        String dayForInputDate = findDayForDate(day, month, year, firstDayOfYear);

        // Output the result
        System.out.println("Day on " + dateInput + " : " + dayForInputDate);
    }

    // Function to validate the date format dd/mm/yyyy
    private static boolean isValidDate(String date) {
        String[] dateParts = date.split("/");
        if (dateParts.length != 3) {
            return false;
        }

        try {
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            // Validate the month and day
            if (month < 1 || month > 12) {
                System.out.println("Invalid month.");
                return false;
            }
            if (day < 1 || day > daysInMonth(month, year)) {
                System.out.println("Invalid day for the given month.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid date format.");
            return false;
        }
    }

    // Function to validate the day input (MONDAY, TUESDAY, etc.)
    private static boolean isValidDay(String day) {
        return day.equals("MONDAY") || day.equals("TUESDAY") || day.equals("WEDNESDAY") ||
                day.equals("THURSDAY") || day.equals("FRIDAY") || day.equals("SATURDAY") ||
                day.equals("SUNDAY");
    }

    // Function to find the number of days in a month
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
                // Check for leap year
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // Function to find the day for a given date
    private static String findDayForDate(int day, int month, int year, String firstDayOfYear) {
        int firstDayIndex = getDayIndex(firstDayOfYear);
        int totalDays = getTotalDaysUpToDate(day, month, year);
        int dayIndex = (firstDayIndex + totalDays) % 7;
        return getDayName(dayIndex);
    }

    // Function to get the day index (0: Sunday, 1: Monday, ..., 6: Saturday)
    private static int getDayIndex(String dayName) {
        switch (dayName) {
            case "MONDAY":
                return 1;
            case "TUESDAY":
                return 2;
            case "WEDNESDAY":
                return 3;
            case "THURSDAY":
                return 4;
            case "FRIDAY":
                return 5;
            case "SATURDAY":
                return 6;
            case "SUNDAY":
                return 0;
            default:
                return -1; // Invalid day
        }
    }

    // Function to get the day name based on the day index
    private static String getDayName(int dayIndex) {
        switch (dayIndex) {
            case 0:
                return "SUNDAY";
            case 1:
                return "MONDAY";
            case 2:
                return "TUESDAY";
            case 3:
                return "WEDNESDAY";
            case 4:
                return "THURSDAY";
            case 5:
                return "FRIDAY";
            case 6:
                return "SATURDAY";
            default:
                return "";
        }
    }

    // Function to calculate the total number of days from 1st January of the given
    // year to the given date
    private static int getTotalDaysUpToDate(int day, int month, int year) {
        int totalDays = 0;

        // Add the days for the months before the given month
        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth(m, year);
        }

        // Add the days in the current month
        totalDays += day - 1;

        return totalDays;
    }
}
