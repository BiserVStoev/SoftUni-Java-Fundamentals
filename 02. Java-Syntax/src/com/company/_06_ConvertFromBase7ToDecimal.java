package com.company;

import java.util.Scanner;

public class _06_ConvertFromBase7ToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a base-7 number to convert to it's decimal representation: ");
        String input = scanner.nextLine();

        int decimal = Integer.parseInt(input, 7);

        System.out.print("Decimal representation: ");
        System.out.println(decimal);
    }
}
