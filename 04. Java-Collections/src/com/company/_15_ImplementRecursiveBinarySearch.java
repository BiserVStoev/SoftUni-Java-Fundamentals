package com.company;

import java.util.Scanner;

/**
 * Binary search is an algorithm that works on already sorted arrays.
 * Basically, it goes to the middle element and checks it has to continue searching to the left, or to the right.
 * Return the index of the element, or -1, if the element is not found.
 */

public class _15_ImplementRecursiveBinarySearch {
    public static void main(String[] args) {
        System.out.print("Enter the number to find in a array: ");

        Scanner scanner = new Scanner(System.in);

        String numberAsString = scanner.nextLine();

        int number = Integer.parseInt(numberAsString);

        System.out.println("Enter the array: ");

        String[] stringArray = scanner.nextLine().split(" ");

        Integer[] numberArray = new Integer[stringArray.length];

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = Integer.parseInt(stringArray[i]);
        }

        int min = 0;

        int max = numberArray.length - 1;

        getIndexOfNumber(numberArray, min, max, number);
    }

    public static void getIndexOfNumber(Integer[] numberArray, int min, int max, int number) {
        if (max < 0 || min > numberArray.length - 1) {
            System.out.println(-1);
            return;
        }

        int midNumIndex = (min + max) / 2;

        if (numberArray[midNumIndex] < number) {
            min = midNumIndex + 1;
        } else if (numberArray[midNumIndex] == number) {
            System.out.println(midNumIndex);
            return;
        } else {
            max = midNumIndex - 1;
        }

        getIndexOfNumber(numberArray, min, max, number);
    }
}
