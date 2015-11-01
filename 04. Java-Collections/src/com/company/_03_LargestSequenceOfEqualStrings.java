package com.company;

import java.util.Scanner;

/**
 * Write a program that enters an array of strings and finds in it the largest sequence of equal elements.
 * If several sequences have the same longest length, print the leftmost of them.
 * The input strings are given as a single line, separated by a space.
 */
public class _03_LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array of strings: ");
        String[] input = scanner.nextLine().split(" ");

        int counter = 1;
        int maxCounter = 1;
        String largetSequence = input[0];



        for (int i = 1; i < input.length; i++) {
            if (input[i].equals(input[i - 1])){
                counter++;
                if (counter > maxCounter){
                    maxCounter = counter;
                    largetSequence = input[i];
                }
            }else{
                counter = 1;
            }
        }

        for (int i = 0; i < maxCounter; i++) {
            if (i != maxCounter - 1){
                System.out.print(largetSequence + " ");
            }else{
                System.out.print(largetSequence);
            }
        }
    }
}
