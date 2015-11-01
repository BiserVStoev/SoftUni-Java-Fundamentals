package com.company;

import java.util.Scanner;

/**
 * Write a program to find how many times given string appears in given text as substring. The text is given at the first input line.
 * The search string is given at the second input line. The output is an integer number. Please ignore the character casing.
 */

public class _07_CountSubstringOccurences {
    public static void main(String[] args) {
        System.out.print("Enter the sentence: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine().toLowerCase();

        System.out.print("Enter a string to find substrings count in sentence: ");

        String string = scanner.nextLine();

        int counter = 0;
        for (int i = 0; i <= sentence.length() - string.length() ; i++) {

            if (string.equals(sentence.substring(i, i + string.length()))){
                counter++;
            }
        }

        System.out.printf("Number of substrings: %d", counter);
    }
}
