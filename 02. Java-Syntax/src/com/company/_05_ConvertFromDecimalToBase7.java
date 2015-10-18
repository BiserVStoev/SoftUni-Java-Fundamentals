package com.company;

import java.util.Scanner;

public class _05_ConvertFromDecimalToBase7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number to convert to base-7: ");
        int number = scanner.nextInt();

        int baseToConvertTo = 7;

        System.out.println("Base-7 number: ");
        System.out.println(Integer.toString(number, baseToConvertTo));
    }
}
