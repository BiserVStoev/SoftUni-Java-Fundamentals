package com.company;

import java.util.Scanner;

/**
 * Write a program to find all increasing sequences inside an array of integers.
 * The integers are given in a single line, separated by a space.
 * Print the sequences in the order of their appearance in the input array, each at a single line.
 * Separate the sequence elements by a space. Find also the longest increasing sequence and print it at the last line.
 * If several sequences have the same longest length, print the leftmost of them.
 */

public class _04_LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array of strings: ");
        String[] input = scanner.nextLine().split(" ");

        Integer[] numsArray = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            numsArray[i] = Integer.parseInt(input[i]);
        }
        int counter = 1;
        int maxCounter = 1;
        StringBuilder longestSequence = new StringBuilder();
        longestSequence.append(numsArray[0] + " ");

        StringBuilder currentSequence = new StringBuilder();
        currentSequence.append(numsArray[0] + " ");
        String longestSequenceHolder = "";
        for (int i = 1; i < input.length; i++) {
            if ( numsArray[i] > numsArray[i - 1]){
                currentSequence.append(numsArray[i] + " ");
                counter++;
                if(counter > maxCounter){
                    maxCounter = counter;
                    longestSequenceHolder = currentSequence.toString().trim();
                    longestSequence.setLength(0);
                    longestSequence.append(longestSequenceHolder);
                }
            }else{
                System.out.println(currentSequence.toString().trim());
                counter = 1;
                currentSequence.setLength(0);
                currentSequence.append(input[i] + " ");
            }

            if (i == input.length - 1){
                System.out.println(currentSequence.toString().trim());
            }
        }

        System.out.printf("Longest: %s", longestSequence);
    }
}
