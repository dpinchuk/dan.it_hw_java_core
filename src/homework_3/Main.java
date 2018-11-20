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
        String[] arrStr;

        while(true) {
            System.out.print("Please, input the day of the week: ");
            inputDay = scanner.nextLine();
            inputDay = inputDay.toLowerCase().trim();
            arrStr = inputDay.split(" ");
            if (arrStr.length == 2 && )

            switch (inputDay) {
                case "sunday":
                    System.out.println("\nYour tasks for " + inputDay + ": '" + scedule[0][1] + "'");
                    break;
                case "monday":
                    System.out.println("\nYour tasks for " + inputDay + ": '" + scedule[1][1] + "'");
                    break;
                case "tuesday":
                    System.out.println("\nYour tasks for " + inputDay + ": '" + scedule[2][1] + "'");
                    break;
                case "wednesday":
                    System.out.println("\nYour tasks for " + inputDay + ": '" + scedule[3][1] + "'");
                    break;
                case "thursday":
                    System.out.println("\nYour tasks for " + inputDay + ": '" + scedule[4][1] + "'");
                    break;
                case "friday":
                    System.out.println("\nYour tasks for " + inputDay + ": '" + scedule[5][1] + "'");
                    break;
                case "saturday":
                    System.out.println("\nYour tasks for " + inputDay + ": '" + scedule[6][1] + "'");
                    break;
                case "exit":
                    System.out.println("\nGoodbye!");
                    isExit = true;
                    break;
                default:
                    System.out.println("\nSorry, I don't understand you, please try again");
            }
            if (isExit) {
                break;
            }

        }
    }

}