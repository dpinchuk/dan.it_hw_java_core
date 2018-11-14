package homework_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/*
 * Write a program of "number", which makes a random number and prompts the player to guess.
 *
 * @author Dmitry Pinchuk
 * */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Initialization of a new array of dimension 0
        int[] arrGamerNumbers = new int[0];
        int indexArray = 0;

        // Random number [0, 100]
        int min = 0;
        int max = 100;
        int rundomNumber = random.nextInt((max - min) + 1);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("\nLet the game begin!");

        System.out.print("Enter your number, please: ");

        // Endless loop
        while (true) {
            int gamerNumber = scanner.nextInt();
            arrGamerNumbers = expansionArray(arrGamerNumbers);
            arrGamerNumbers[indexArray++] = gamerNumber;
            quickSortArray(arrGamerNumbers, 0, arrGamerNumbers.length - 1);

            // Сonditions
            if (gamerNumber < rundomNumber) {
                System.out.println("Your number is too small. Please, try again...");
            } else if (gamerNumber > rundomNumber) {
                System.out.println("Your number is too big. Please, try again...");
            } else {
                System.out.println("Congratulations, " + name + "!");
                System.out.println("Hidden number is '" + gamerNumber + "'");
                System.out.println("Your numbers: " + Arrays.toString(arrGamerNumbers));
                break;
            }
            System.out.print("Enter your number, please: ");
        }
    }

    /**
     * The method increases the size of the array by 1
     *
     * @param arr - array
     */
    private static int[] expansionArray(int[] arr) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, newArr.length - 1);
        newArr[newArr.length - 1] = 0;
        return newArr;
    }

    /**
     * Quick array sorting method
     *
     * @param arr  - array
     * @param low  - low array index
     * @param high - high array index
     */
    private static void quickSortArray(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high) {
            return;
        }

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSortArray(arr, low, j);

        if (high > i)
            quickSortArray(arr, i, high);
    }

}