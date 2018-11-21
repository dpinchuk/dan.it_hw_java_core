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
        int targetSize = targetCapacity;

        System.out.println("All set. Get ready to rumble!\n");

        // random getting target start point for setting target
        int xTarget = random.nextInt(M - 1);
        int yTarget = random.nextInt(N - 1);

        int[][] square = setTarget(targetCapacity, xTarget, yTarget, M, N);
        printBattleArray(square, M, N, false);

        // Endless loop and main logic
        while (true) {
            System.out.print("\nEnter the Row for shooting [1, 5]: ");
            int shootingRow = scanner.nextInt();
            shootingRow = inputTarget(shootingRow, 1, M, scanner);
            shootingRow--;

            System.out.print("\nEnter the Column for shooting [1, 5]: ");
            int shootingColumn = scanner.nextInt();
            shootingColumn = inputTarget(shootingColumn, 1, N, scanner);
            shootingColumn--;

            // checks for target mean
            switch (square[shootingRow][shootingColumn]) {
                case -1:
                    square[shootingRow][shootingColumn] = -1;
                    break;
                case 0:
                    square[shootingRow][shootingColumn] = -1;
                    break;
                case 1:
                    targetSize--;
                    square[shootingRow][shootingColumn] = 2;
                    break;
                case 2:
                    square[shootingRow][shootingColumn] = 2;
                    break;
            }
            // prints current array
            printBattleArray(square, M, N, false);

            // exit condition
            if (targetSize == 0) {
                System.out.println("\nYou have won!");
                break;
            }
        }
    }

    /**
     *
     * @param targetCapacity        target size
     * @param shootingRow           target row
     * @param shootingColumn        target column
     * @param m                     array rows
     * @param n                     array columns
     * @return                      array[m][n] with settings targets
     */
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

    /**
     *
     * @param arr               array[m][n]
     * @param m                 array rows
     * @param n                 array columns
     * @param isTargetHide      'true' if you want to hide the target, otherwise 'false'
     */
    private static void printBattleArray(int[][] arr, int m, int n, boolean isTargetHide) {
        int p = 0, k = 0;
        for (int i = -1; i < m; i++) {
            k++;
            for (int j = -1; j < n; j++) {
                if (i == -1 || j == -1) {
                    System.out.print(p++ + "  ");
                } else {
                    if (arr[i][j] == -1) {
                        System.out.print("*  ");
                    } else if (arr[i][j] == 0) {
                        System.out.print("-  ");
                    } else if (arr[i][j] == 1) {
                        if (isTargetHide) {
                            System.out.print(0 + "  ");
                        } else {
                            System.out.print(arr[i][j] + "  ");
                        }
                    } else if (arr[i][j] == 2) {
                        System.out.print("x  ");
                    }
                }
            }
            System.out.println();
            p = k;
        }
    }

    /**
     *
     * @param target        current gamer target
     * @param boundMin      min boundary
     * @param boundMax      max boundary
     * @param scanner       scanner object
     * @return              target
     */
    private static int inputTarget(int target, int boundMin, int boundMax, Scanner scanner) {
        // Checking of the entered number
        while (target < boundMin || target > boundMax) {
            System.out.print("Enter the correct Row for shooting: ");
            target = scanner.nextInt();
        }
        return target;
    }

}