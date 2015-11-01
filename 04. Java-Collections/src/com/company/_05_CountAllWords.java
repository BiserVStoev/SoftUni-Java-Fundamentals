package com.company;

import java.util.Scanner;

/**
 * Write a program to count the number of words in given sentence. Use any non-letter character as word separator.
 */

public class _05_CountAllWords {
    public static void main(String[] args) {
        System.out.print("Enter a sentence: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        System.out.println("Number of words in the sentence: " + sentence.split("\\W+").length);

    }
}
