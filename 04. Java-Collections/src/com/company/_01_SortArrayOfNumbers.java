package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program to enter a number n and n integer numbers and sort and print them. Keep the numbers in array of integers: int[].
 */

public class _01_SortArrayOfNumbers {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int arrayLength = scanner.nextInt();

        
        int[] arrayOfNums = new int[arrayLength];

        System.out.print("Enter the array: ");
        for (int i = 0; i < arrayOfNums.length; i++) {
            arrayOfNums[i] = scanner.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arrayOfNums);

        for (Integer num : arrayOfNums){
            sb.append(num + " ");
        }

        System.out.print("Sorted array: ");
        System.out.print(sb.toString().trim());
}
}
