package com.company;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Biser on 16-Oct-15.
 */
public class _04_CalculateExpressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNum = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNum = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double thirdNum = scanner.nextDouble();

        double firstResult = getFirstResult(firstNum, secondNum, thirdNum);

        double secondResult = getSecondResult(firstNum, secondNum, thirdNum);

        double numberAverage = getNumAverage(firstNum, secondNum, thirdNum);

        double resultsAverage = getResultsAverage(firstResult, secondResult);

        double difference = Math.abs(numberAverage - resultsAverage);
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", firstResult, secondResult, difference);
    }

    public  static double getFirstResult (double firstNum, double secondNum, double thirdNum){

        return Math.pow((Math.pow(firstNum, 2) + Math.pow(secondNum, 2)) / (Math.pow(firstNum, 2) - Math.pow(secondNum, 2)) ,
                (firstNum + secondNum + thirdNum) / Math.sqrt(thirdNum));
    }

    public  static double getSecondResult (double firstNum, double secondNum, double thirdNum){

        return Math.pow(Math.pow(firstNum, 2) + Math.pow(secondNum, 2) - Math.pow(thirdNum, 3), firstNum - secondNum);
    }

    public  static double getNumAverage (double firstNum, double secondNum, double thirdNum){

        return (firstNum + secondNum + thirdNum) / 3;
    }

    private static double getResultsAverage(double firstResult, double secondResult) {
        return (firstResult + secondResult) / 2;
    }
}
