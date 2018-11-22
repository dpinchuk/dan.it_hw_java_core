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
                System.out.println("Buy!");
                break;
            }

            if (inputDay.split(" ").length == 1) {
                for (int i = 0; i < scedule.length; i++) {
                    if (inputDay.equals(scedule[i][0].toLowerCase())) {
                        getScheduleForCurrentDay(scedule[i][0].toLowerCase(), scedule);
                        break;
                    }
                    if (i == scedule.length - 1) {
                        System.out.println("\nSorry, I don't understand you, please try again");
                        break;
                    }
                }
            } else if (inputDay.replaceAll("[\\s]{2,}", " ").split(" ").length == 2) {
                inputDay = inputDay.replaceAll("[\\s]{2,}", " ");
                for (int i = 0; i < scedule.length; i++) {
                    if ((inputDay.contains(scedule[i][0].toLowerCase())) &&
                            (inputDay.contains("change") || inputDay.contains("reschedule"))) {
                        setScheduleForCurrentDay(scedule[i][0], scedule, i, scanner);
                        break;
                    }
                    if (i == scedule.length - 1) {
                        System.out.println("\nSorry, I don't understand you, please try again");
                        break;
                    }
                }
            } else {
                System.out.println("Sorry, I don't understand you, please try again");
            }

        }
    }

    private static void setScheduleForCurrentDay(String schedule, String[][] scedule, int i, Scanner scanner) {
        System.out.print("\nPlease, input new tasks for '" + schedule + "': ");
        scedule[i][1] = scanner.nextLine();
        System.out.println();
    }

    private static void getScheduleForCurrentDay(String day, String[][] scedule) {
        switch (day) {
            case "sunday":
                System.out.println("Your tasks for " + scedule[0][0] + ": '" + scedule[0][1] + "'\n");
                break;
            case "monday":
                System.out.println("Your tasks for " + scedule[1][0] + ": '" + scedule[1][1] + "'\n");
                break;
            case "tuesday":
                System.out.println("Your tasks for " + scedule[2][0] + ": '" + scedule[2][1] + "'\n");
                break;
            case "wednesday":
                System.out.println("Your tasks for " + scedule[3][0] + ": '" + scedule[3][1] + "'\n");
                break;
            case "thursday":
                System.out.println("Your tasks for " + scedule[4][0] + ": '" + scedule[4][1] + "'\n");
                break;
            case "friday":
                System.out.println("Your tasks for " + scedule[5][0] + ": '" + scedule[5][1] + "'\n");
                break;
            case "saturday":
                System.out.println("Your tasks for " + scedule[6][0] + ": '" + scedule[6][1] + "'\n");
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again\n");
        }
    }

}