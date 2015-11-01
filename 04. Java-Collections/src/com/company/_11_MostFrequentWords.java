package com.company;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Write a program to find the most frequent word in a text and print it, as well as how many times it appears in format "word -> count".
 * Consider any non-letter character as a word separator. Ignore the character casing.
 * If several words have the same maximal frequency, print all of them in alphabetical order.
 */

public class _11_MostFrequentWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text to find the most frequent word: ");

        String[] text = scanner.nextLine().toLowerCase().split("\\W+");

        TreeMap<String, Integer> words = new TreeMap<>();

        for (String word : text){
            if (!words.containsKey(word)){
                words.put(word, 1);
            }else{
                Integer previousValue = words.get(word);
                words.put(word, previousValue + 1);
            }
        }

        int highestCount = 0;
        for(String word : words.keySet()){
            int count = words.get(word);
            if(count > highestCount){
                highestCount = count;
            }
        }

        for(String word : words.keySet()){
            int count = words.get(word);
            if(count == highestCount){
                System.out.printf("%s -> %d times \n", word, count);
            }
        }
    }
}
