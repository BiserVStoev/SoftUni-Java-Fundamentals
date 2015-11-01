package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * We are given a sequence of N playing cards from a standard deck. The input consists of several cards (face + suit), separated by a space.
 * Write a program to calculate and print at the console the frequency of each card face in format "card_face -> frequency".
 * The frequency is calculated by the formula appearances / N and is expressed in percentages with exactly 2 digits after the decimal point.
 * The card faces with their frequency should be printed in the order of the card face's first appearance in the input.
 * The same card can appear multiple times in the input, but it's face should be listed only once in the output.
 */

public class _12_CardsFrequencies {
    public static void main(String[] args) {
        System.out.printf("Enter the set of cards: ");

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().trim().split(" ");

        LinkedHashMap<String, Integer> facesAndTheirCount = new LinkedHashMap<>();


        for (int i = 0; i < input.length; i++) {
            String cardFace = input[i].substring(0, input[i].length() - 1);
            if (!facesAndTheirCount.containsKey(cardFace)){
                facesAndTheirCount.put(cardFace, 1);
            }else{
                Integer previousValue = facesAndTheirCount.get(cardFace);
                facesAndTheirCount.put(cardFace, previousValue + 1);
            }
        }

        for (String card : facesAndTheirCount.keySet()){
            double frequency = (facesAndTheirCount.get(card) / (double)input.length) * 100;
            System.out.printf("%s -> %.2f%%", card, frequency);
            System.out.println();

        }
    }
}
