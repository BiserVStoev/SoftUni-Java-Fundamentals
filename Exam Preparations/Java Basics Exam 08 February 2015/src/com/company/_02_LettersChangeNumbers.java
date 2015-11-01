package com.company;

import java.util.Scanner;

public class _02_LettersChangeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (int i = 0; i < input.length; i++) {
            String[] twoLetters = input[i].split("\\d+");

            double firstLetterValue = getFirstLetterValue(twoLetters[0],Double.parseDouble(input[i].toString().replaceAll("[a-zA-Z]+", "")));
            double secondLetterValue = getSecondLetterValue(twoLetters[1], firstLetterValue);

            sum += secondLetterValue;
        }

        System.out.printf("%.2f", sum);
    }

    public static double getFirstLetterValue(String letter, double number){

        if (letter.matches("[a-z]")){

            return number * ((int)letter.charAt(0) - 96);
        }else{

            return number / ((int)letter.charAt(0) - 64);
        }
    }

    public static double getSecondLetterValue(String letter, double firstValue){

        if (letter.matches("[a-z]")){

            return firstValue + ((int)letter.charAt(0) - 96);
        }else{

            return firstValue - ((int)letter.charAt(0) - 64);
        }
    }
}
