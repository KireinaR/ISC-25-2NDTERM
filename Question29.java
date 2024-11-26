package Java.Class12;

import java.util.Scanner;

public class Question29 {
    // Constants for Mayan date system
    private static final int DAYS_IN_UINAL = 20;
    private static final int UINALS_IN_TUN = 18;
    private static final int TUNS_IN_KATUN = 20;
    private static final int KATUNS_IN_BAKTUN = 20;

    // Days in months for Gregorian calendar
    private static final int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // Reference dates
    private static final int REF_BAKTUN = 13;
    private static final int REF_KATUN = 20;
    private static final int REF_TUN = 7;
    private static final int REF_UINAL = 16;
    private static final int REF_KIN = 3;
    private static final int REF_YEAR = 2000;
    private static final int REF_MONTH = 1; // January
    private static final int REF_DAY = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Mayan date
        System.out.println("Enter Mayan date (baktun katun tun uinal kin):");
        int baktun = scanner.nextInt();
        int katun = scanner.nextInt();
        int tun = scanner.nextInt();
        int uinal = scanner.nextInt();
        int kin = scanner.nextInt();

        // Calculate total days from reference Mayan date to the input Mayan date
        int totalMayanDays = calculateMayanDays(baktun, katun, tun, uinal, kin)
                - calculateMayanDays(REF_BAKTUN, REF_KATUN, REF_TUN, REF_UINAL, REF_KIN);

        // Convert the days from reference Gregorian date
        int[] resultDate = calculateGregorianDate(totalMayanDays);

        // Output result
        System.out.println(resultDate[2] + " " + resultDate[1] + " " + resultDate[0]); // day, month, year format

        scanner.close();
    }

    // Method to calculate days from reference Mayan date
    private static int calculateMayanDays(int baktun, int katun, int tun, int uinal, int kin) {
        int totalDays = 0;
        totalDays += (baktun - 1) * KATUNS_IN_BAKTUN * TUNS_IN_KATUN * UINALS_IN_TUN * DAYS_IN_UINAL;
        totalDays += (katun - 1) * TUNS_IN_KATUN * UINALS_IN_TUN * DAYS_IN_UINAL;
        totalDays += (tun - 1) * UINALS_IN_TUN * DAYS_IN_UINAL;
        totalDays += (uinal - 1) * DAYS_IN_UINAL;
        totalDays += kin - 1;
        return totalDays;
    }

    // Method to calculate Gregorian date from days offset
    private static int[] calculateGregorianDate(int daysFromReference) {
        int day = REF_DAY;
        int month = REF_MONTH;
        int year = REF_YEAR;

        while (daysFromReference > 0) {
            int daysInCurrentMonth = DAYS_IN_MONTH[month - 1];
            if (month == 2 && isLeapYear(year)) {
                daysInCurrentMonth = 29;
            }
            if (daysFromReference < daysInCurrentMonth - day + 1) {
                day += daysFromReference;
                daysFromReference = 0;
            } else {
                daysFromReference -= (daysInCurrentMonth - day + 1);
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
        }

        return new int[] { year, month, day };
    }

    // Method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }
}
