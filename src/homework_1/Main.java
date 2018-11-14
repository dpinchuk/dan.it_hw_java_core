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
        final int N = 100;
        int rundomNumber = random.nextInt(N);
        String gamerNumberStr = "";
        int gamerNumber = 0;

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("\nLet the game begin!");
        System.out.print("Enter your number, please: ");

        // Endless loop
        while (true) {
            boolean isNumber = false;
            while(!isNumber) {
                gamerNumberStr = scanner.nextLine();
                try {
                    gamerNumber = Integer.parseInt(gamerNumberStr);
                    isNumber = true;
                } catch(Exception e) {
                    System.out.print("Enter correct number, please: ");
                }
            }

            arrGamerNumbers = expansionArray(arrGamerNumbers);
            arrGamerNumbers[indexArray++] = gamerNumber;
            //quickSortArray(arrGamerNumbers, 0, arrGamerNumbers.length - 1);
            bubbleSortDescendingArray(arrGamerNumbers);

            // Сonditions
            if (gamerNumber < rundomNumber) {
                System.out.println("Your number is too small. Please, try again...");
                System.out.println("Your numbers: " + Arrays.toString(arrGamerNumbers));
            } else if (gamerNumber > rundomNumber) {
                System.out.println("Your number is too big. Please, try again...");
                System.out.println("Your numbers: " + Arrays.toString(arrGamerNumbers));
            } else {
                System.out.println("\nCongratulations, " + name + "!");
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
     * @param arr
     * @param low
     * @param high
     * @void
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

    /**
     * Bubble sorting array [Time complexity: O(n^2)]
     *
     * @param arr
     * @return
     */
    private static void bubbleSortDescendingArray(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] < arr[j]) {
                    arr[j] = arr[j] + arr[j - 1];
                    arr[j - 1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j - 1];
                }
            }
        }
    }

}