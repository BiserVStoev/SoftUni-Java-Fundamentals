package com.company;

import java.util.Scanner;

public class _03_Biggest3PrimeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine().replaceAll("[()]+", " ").trim();

        System.out.println(string);
        String[] input = string.split("\\s+");

        Integer[] nums = new Integer[input.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int biggestPrime = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (isPrime(nums[i]) && nums[i] >= 0){
                if (biggestPrime < nums[i]){
                    biggestPrime = nums[i];
                }
            }
        }

        int secondBiggestPrime = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (isPrime(nums[i]) && nums[i] >= 0){
                if (secondBiggestPrime < nums[i] && nums[i] < biggestPrime){
                    secondBiggestPrime = nums[i];
                }
            }
        }

        int thirdBiggestPrime = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (isPrime(nums[i]) && nums[i] >= 0){
                if (thirdBiggestPrime < nums[i] && nums[i] < secondBiggestPrime){
                    thirdBiggestPrime = nums[i];
                }
            }
        }

        if (biggestPrime != Integer.MIN_VALUE && secondBiggestPrime != Integer.MIN_VALUE && thirdBiggestPrime != Integer.MIN_VALUE ){
            System.out.println(biggestPrime + secondBiggestPrime + thirdBiggestPrime);
        }else {
            System.out.println("No");
        }
    }

    public static boolean isPrime(int number)
    {
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0 && i != number)
                return false;
        }
        return true;
    }
}
