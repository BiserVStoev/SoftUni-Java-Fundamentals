package com.company;

import java.util.Scanner;

public class _08_GetAverage {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNum = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNum = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double thirdNum = scanner.nextDouble();

        double averageNum = average(firstNum, secondNum, thirdNum);

        System.out.printf("%.2f", averageNum);
    }

    public static double average(double firstNum, double secondNum, double thirdNum){
        double averageNum = (firstNum + secondNum + thirdNum) / 3;
        return  averageNum;
    }
}
