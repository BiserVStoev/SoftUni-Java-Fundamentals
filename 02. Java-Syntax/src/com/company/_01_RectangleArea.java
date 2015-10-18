package com.company;

import java.util.Scanner;

public class _01_RectangleArea {

    public static void main(String[] args) {
        System.out.print("Enter the two numbers in order to calculate the rectangle area: ");

        Scanner scanner = new Scanner(System.in);

        String[] stringInput = scanner.nextLine().split(" ");

        int firstNum = Integer.parseInt(stringInput[0]);
        int secondNum = Integer.parseInt(stringInput[1]);

        int rectangelArea = firstNum * secondNum;

        System.out.print("Rectangle area: ");
        System.out.println(rectangelArea);
    }
}
