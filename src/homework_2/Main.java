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
        int targetCapacity = 3; // Only less M or N !!!

        System.out.println("All set. Get ready to rumble!\n");

        int xTarget = new Random().nextInt(M - 1);
        int yTarget = new Random().nextInt(N - 1);

        int[][] square = setTarget(targetCapacity, xTarget, yTarget, M, N);
        printBattleArray(square, M, N, false);

        // Endless loop
        while (true) {
            System.out.print("\nEnter the Row for shooting [1, 5]: ");
            int shootingRow = scanner.nextInt();
            // Checking of the entered number
            while (shootingRow < 1 || shootingRow > M) {
                System.out.print("Enter the correct Row for shooting: ");
                shootingRow = scanner.nextInt();
            }
            shootingRow--;

            System.out.print("\nEnter the Column for shooting [1, 5]: ");
            // Checking of the entered number
            int shootingColumn = scanner.nextInt();
            while (shootingColumn < 1 || shootingColumn > N) {
                System.out.print("Enter the correct Column for shooting: ");
                shootingColumn = scanner.nextInt();
            }
            shootingColumn--;

            if (square[shootingRow][shootingColumn] == 1) {
                square[shootingRow][shootingColumn] = 2;
            } else {

            }

            break;
        }
    }

    private static int[][] setTarget(int targetCapacity, int shootingRow, int shootingColumn, int m, int n) {
        //vertical = true; Horizontal = false
        int[][] battleField = new int[m][n];
        boolean isVertical = new Random().nextBoolean();
        int index = 0;
        if (isVertical) {
            for (int j = 0; j < targetCapacity; j++) {
                if (shootingColumn + j > n - 1) {
                    battleField[shootingRow][index++] = 1;
                } else {
                    battleField[shootingRow][shootingColumn + j] = 1;
                }
            }
        } else {
            for (int i = 0; i < targetCapacity; i++) {
                if (shootingRow + i > m - 1) {
                    battleField[index++][shootingColumn] = 1;
                } else {
                    battleField[shootingRow + i][shootingColumn] = 1;
                }
            }
        }
        return battleField;
    }

    private static void printBattleArray(int[][] arr, int m, int n, boolean isHide) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isHide) {
                    if (arr[i][j] == 1) {
                        System.out.print(0 + " ");
                    } else {
                        System.out.print(arr[i][j] + " ");
                    }
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}