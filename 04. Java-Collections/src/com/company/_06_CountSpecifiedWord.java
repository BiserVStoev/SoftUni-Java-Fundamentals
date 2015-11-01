package com.company;

import java.util.Scanner;

/**
 *Write a program to find how many times a word appears in given text. The text is given at the first input line.
 *  The target word is given at the second input line. The output is an integer number. Please ignore the character casing.
 *  Consider that any non-letter character is a word separator.
 */

public class _06_CountSpecifiedWord {
    public static void main(String[] args) {
        System.out.print("Enter a sentence: ");

        Scanner scanner = new Scanner(System.in);

        String[] sentence = scanner.nextLine().toLowerCase().split("\\W+");

        System.out.print("Enter the word to find how many times it's present in the sentence: ");

        String word = scanner.nextLine();

        int count = 0;

        for (String inputWord : sentence) {
            if (word.toLowerCase().equals(inputWord.toLowerCase()))
                count++;
        }

        System.out.printf("Times the word appears in the sentence: %d", count);
    }
}
