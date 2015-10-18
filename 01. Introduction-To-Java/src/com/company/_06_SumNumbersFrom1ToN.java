package com.company;


import java.util.Scanner;

public class _06_SumNumbersFrom1ToN {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter num: ");
        int nums = scanner.nextInt();

        int sum = 0;

        for (int i = 1; i <= nums; i++) {

            sum += i;
        }

        System.out.println(sum);
    }
}