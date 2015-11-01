package com.company;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class _02_ThreeLargestNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        BigDecimal[] numbers = new BigDecimal[count];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextBigDecimal();
        }

        Arrays.sort(numbers);

        int counter = 0;
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            System.out.println(numbers[i].toPlainString());
            counter++;
            if (counter == 3){
                break;
            }
        }

    }

}
