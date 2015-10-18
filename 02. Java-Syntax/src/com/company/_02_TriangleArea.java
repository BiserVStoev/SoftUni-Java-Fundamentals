package com.company;

import java.util.Scanner;

public class _02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first set of coordinates: ");

        String[] stringInput = scanner.nextLine().split(" ");

        int aX = Integer.parseInt(stringInput[0]);
        int aY = Integer.parseInt(stringInput[1]);

        System.out.print("Enter the second set of coordinates: ");
        stringInput = scanner.nextLine().split(" ");

        int bX = Integer.parseInt(stringInput[0]);
        int bY = Integer.parseInt(stringInput[1]);

        System.out.print("Enter the third set of coordinates: ");
        stringInput = scanner.nextLine().split(" ");

        int cX = Integer.parseInt(stringInput[0]);
        int cY = Integer.parseInt(stringInput[1]);

        int triangleArea = Math.abs(aX*(bY - cY) + bX*(cY - aY) + cX*(aY - bY)) / 2;

            System.out.print("Triangle area: ");
            System.out.println(triangleArea);
    }
}
