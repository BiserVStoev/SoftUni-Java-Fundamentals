package com.company;

import java.util.Scanner;

/**
 * Write a program that recursively calculates factorial.
 */

public class _16_CalculateN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(scanner.nextLine());

        int factorial = 1;

        getFactorial(number, factorial);
    }

    public static void getFactorial(int number, int factorial){

        if ( number == 1){
            System.out.println("Factorial: " + factorial);
            return;
        }
        factorial *= number;

        getFactorial(number - 1, factorial);
    }
}
