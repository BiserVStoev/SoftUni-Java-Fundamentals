package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Write a program that filters an array of strings, leaving only the strings with length greater than 3 characters. Use .filter()
 */

public class _13_FilterArray {
    public static void main(String[] args) {
        System.out.print("Enter array of strings: ");

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        List<String> output = Arrays.asList(input).stream().filter(w -> w.length() > 3).collect(Collectors.toList());

        if (output.size() == 0){
            System.out.println("(empty)");
            return;
        }

        for (String word : output){
            System.out.print(word + " ");
        }
    }
}
