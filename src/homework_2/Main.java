package homework_2;

import java.util.Random;
import java.util.Scanner;

/*
 * Write a program "shooting on the square".
 *
 * @author Dmitry Pinchuk
 * */
public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        final int M = 5;
        final int N = 5;
        int targetCapacity = 3;
        int[][] square = new int[M][N];

        System.out.println("All set. Get ready to rumble!\n");

        // init target coordinates
        int xTarget = random.nextInt(M);
        int yTarget = random.nextInt(N);
        square[xTarget][yTarget] = 2;

        // Endless loop
        while (true) {
            System.out.print("Enter the Row for shooting: ");
            int shootingRow = scanner.nextInt();
            // Checking of the entered number
            while (shootingRow < 1 & shootingRow > N) {
                System.out.print("Enter the correct line for shooting: ");
                shootingRow = scanner.nextInt();
            }

            System.out.print("Enter the Column for shooting: ");
            // Checking of the entered number
            int shootingColumn = scanner.nextInt();
            while (shootingColumn < 1 & shootingColumn > N) {
                System.out.print("Enter the correct line for shooting: ");
                shootingRow = scanner.nextInt();
            }

            if (square[shootingRow][shootingColumn] == 2) {
                System.out.println("You have won!");
                break;
            } else {
                // The array element is marked 1
                square[shootingRow][shootingColumn] = 1;
            }

        }

    }

    private int[][] setTarget(int[][] arr, int targetCapacity, int xTarget, int yTarget) {
        if (xTarget == 0) {
            for (int i = 0; i < targetCapacity; i++) {
                arr[i][yTarget] = 2;
            }
        } else if (xTarget == arr.length) {

        }

        return null;
    }

    private void printSquare(int[][] arr, int m, int n) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.println();
            }
            System.out.println();
        }
    }

}