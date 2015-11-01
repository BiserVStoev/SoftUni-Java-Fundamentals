package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03_LongestOddEvenSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().replaceAll("\\s+", "").replaceAll("\\(", "").trim().split("\\)");

        Integer[] numbers = new Integer[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int largestSubSequelnceLength = 1;
        int currentSubsequenceLength = 1;

        for (int i = 1; i < numbers.length; i++) {

            String lastNumType = getNumberType(numbers[i - 1]);

            String currentNumType = getNumberType(numbers[i]);

            if (!lastNumType.equals(currentNumType) || currentNumType.equals("special") || lastNumType.equals("special")){
                currentSubsequenceLength++;
                if (currentSubsequenceLength > largestSubSequelnceLength){
                    largestSubSequelnceLength = currentSubsequenceLength;
                }
            }else{
                currentSubsequenceLength = 1;
            }
        }
        System.out.println(largestSubSequelnceLength);
    }

    public static String getNumberType(int number){

        if (number == 0){
            return "special";
        }else{
            if (number % 2 == 0){
                return "even";
            }else{
                return "odd";
            }
        }
    }
}
