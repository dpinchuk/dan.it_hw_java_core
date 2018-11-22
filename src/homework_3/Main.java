package homework_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // init constants
        final int M = 7;
        final int N = 2;

        // creating array[][] of Strings
        String[][] scedule = new String[M][N];

        // filling array
        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";

        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses; watch a film";

        scedule[2][0] = "Tuesday";
        scedule[2][1] = "do first project";

        scedule[3][0] = "Wednesday";
        scedule[3][1] = "do second project";

        scedule[4][0] = "Thursday";
        scedule[4][1] = "do third project";

        scedule[5][0] = "Friday";
        scedule[5][1] = "go to beer";

        scedule[6][0] = "Saturday";
        scedule[6][1] = "go to courses";

        Scanner scanner = new Scanner(System.in);
        String inputDay = "";
        boolean isExit = false;

        while (true) {
            System.out.print("Please, input the day of the week: ");
            inputDay = scanner.nextLine();
            inputDay = inputDay.toLowerCase().trim();

            if (inputDay.equals("exit")) {
                break;
            }

            if (inputDay.split(" ").length == 1) {
                for (int i = 0; i < scedule.length; i++) {
                    if (inputDay.equals(scedule[i][0])) {
                        getScheduleForCurrentDay(scedule[i][0], scedule);
                        break;
                    }
                    if (i == scedule.length - 1) {
                        System.out.println("Sorry, I don't understand you, please try again");
                        break;
                    }
                }
            } else if (inputDay.split(" ").length == 2) {
                for (int i = 0; i < scedule.length; i++) {
                    if ((inputDay.contains(scedule[i][0])) &&
                            (inputDay.contains("change") || inputDay.contains("reschedule"))) {
                        setScheduleForCurrentDay(scedule[i][0], scedule, i, scanner);
                        break;
                    }
                    if (i == scedule.length - 1) {
                        System.out.println("Sorry, I don't understand you, please try again");
                        break;
                    }
                }
            } else {
                System.out.println("Sorry, I don't understand you, please try again");
            }

        }
    }

    private static void setScheduleForCurrentDay(String schedule, String[][] scedule, int i, Scanner scanner) {
        System.out.println("\nPlease, input new tasks for " + schedule);
        scedule[i][1] = scanner.nextLine();

    }

    private static String getScheduleForCurrentDay(String day, String[][] scedule) {
        switch (day) {
            case "sunday":
                return "\nYour tasks for " + day + ": '" + scedule[0][1] + "'";
            case "monday":
                return "\nYour tasks for " + day + ": '" + scedule[1][1] + "'";
            case "tuesday":
                return "\nYour tasks for " + day + ": '" + scedule[2][1] + "'";
            case "wednesday":
                return "\nYour tasks for " + day + ": '" + scedule[3][1] + "'";
            case "thursday":
                return "\nYour tasks for " + day + ": '" + scedule[4][1] + "'";
            case "friday":
                return "\nYour tasks for " + day + ": '" + scedule[5][1] + "'";
            case "saturday":
                return "\nYour tasks for " + day + ": '" + scedule[6][1] + "'";
        }
        return "\nSorry, I don't understand you, please try again";
    }

}