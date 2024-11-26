package Java.Class12;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Question21 {

    // Formatter that accepts both single- and double-digit hours
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm dd-MM-yyyy");

    private UserLog[] userLogs;
    private int numUsers;

    public static void main(String[] args) {
        Question21 analyzer = new Question21();
        analyzer.collectData();
        analyzer.displayDurations();
        analyzer.displayLongestDuration();
    }

    // Inner class to hold user log data
    private class UserLog {
        String userId;
        LocalDateTime loginTime;
        LocalDateTime logoutTime;
        Duration duration;

        public UserLog(String userId, LocalDateTime loginTime, LocalDateTime logoutTime) {
            this.userId = userId;
            this.loginTime = loginTime;
            this.logoutTime = logoutTime;
            this.duration = Duration.between(loginTime, logoutTime);
        }

        public long getHours() {
            return duration.toHours();
        }

        public long getMinutes() {
            return duration.toMinutes() % 60;
        }
    }

    // Function to collect user data
    private void collectData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of users: ");
        numUsers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        userLogs = new UserLog[numUsers]; // Initialize the array with the number of users
        int currentYear = LocalDateTime.now().getYear(); // Get current year

        for (int i = 0; i < numUsers; i++) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter Login Time (HH:MM DD-MM): ");
            String loginTimeStr = scanner.nextLine() + "-" + currentYear;
            LocalDateTime loginTime = LocalDateTime.parse(loginTimeStr, formatter);

            System.out.print("Enter Logout Time (HH:MM DD-MM): ");
            String logoutTimeStr = scanner.nextLine() + "-" + currentYear;
            LocalDateTime logoutTime = LocalDateTime.parse(logoutTimeStr, formatter);

            userLogs[i] = new UserLog(userId, loginTime, logoutTime);
        }
        scanner.close();
    }

    // Function to display each user's duration
    private void displayDurations() {
        System.out.println("\nUSER LOGIN LOGOUT DURATION");
        System.out.println("IDENTIFICATION TIME & DATE   TIME & DATE   HOURS : MINS");
        for (int i = 0; i < numUsers; i++) {
            UserLog log = userLogs[i];
            System.out.printf("%s          %s    %s    %02d : %02d%n",
                    log.userId,
                    log.loginTime.format(formatter),
                    log.logoutTime.format(formatter),
                    log.getHours(),
                    log.getMinutes());
        }
    }

    // Function to find and display the user with the longest duration
    private void displayLongestDuration() {
        UserLog longestLog = userLogs[0];
        for (int i = 1; i < numUsers; i++) {
            if (userLogs[i].duration.compareTo(longestLog.duration) > 0) {
                longestLog = userLogs[i];
            }
        }

        System.out.println("\nTHE USER WHO LOGGED IN FOR THE LONGEST DURATION:");
        System.out.printf("%s %s %s %02d : %02d%n",
                longestLog.userId,
                longestLog.loginTime.format(formatter),
                longestLog.logoutTime.format(formatter),
                longestLog.getHours(),
                longestLog.getMinutes());
    }
}
