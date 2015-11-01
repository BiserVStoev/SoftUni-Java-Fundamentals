package com.company;


import java.math.BigDecimal;
import java.util.Scanner;

public class _03_SimpleExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll("-\\s*?", " -").replaceAll("\\+", " " ).replaceAll("-\\s+", " -").trim();

        String[] numbers = input.split("\\s+");

        BigDecimal[] decimalNums = new BigDecimal[numbers.length];

        for (int i = 0; i < decimalNums.length; i++) {
            decimalNums[i] = new BigDecimal(numbers[i]);
        }

        BigDecimal output = BigDecimal.ZERO;

        for (BigDecimal decimal : decimalNums){
            output = output.add(decimal);
        }
        System.out.printf("%.7f", output);
    }
}
