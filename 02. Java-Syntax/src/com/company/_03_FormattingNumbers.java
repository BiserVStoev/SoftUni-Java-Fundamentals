package com.company;

import java.util.Scanner;

public class _03_FormattingNumbers {
    public static void main(String[] args) {
        System.out.print("Enter the first number: ");
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        System.out.print("Enter the second number: ");
        double secondNum = scanner.nextDouble();
        System.out.print("Enter the third number: ");
        double thirdNum = scanner.nextDouble();

        int binaryNum = Integer.parseInt(Integer.toString(firstNum, 2));
        System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|",
                Integer.toHexString(firstNum).toUpperCase(),binaryNum, secondNum, thirdNum);
    }
}
