package com.company;

import java.util.*;

/**
 * At the first line at the console you are given a piece of text. Extract all words from it and print them in alphabetical order.
 * Consider each non-letter character as word separator. Take the repeating words only once. Ignore the character casing.
 * Print the result words in a single line, separated by spaces.
 */

public class _10_ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text to extract all unique words: ");
        String[] input = scanner.nextLine().toLowerCase().split("\\W+");

        Set<String> uniqueWords = new HashSet<>();

        for (String word : input){
            uniqueWords.add(word);
        }

        System.out.print("Unique words: ");

        for (String word : uniqueWords){
            System.out.print(word + " ");
        }
    }
}
