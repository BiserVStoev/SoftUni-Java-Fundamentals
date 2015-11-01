package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_WeirdStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll("[ \\/\\\\)(|]+", "").trim();

        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        Matcher matcher = pattern.matcher(input);

        List<String> words = new ArrayList<>();

        while (matcher.find()){
            words.add(matcher.group());
        }

        int maxSum = Integer.MIN_VALUE;
        String output = "";

        for (int i = 0; i < words.size() - 1; i++) {
            int currentSum = getWordWeight(words.get(i).toLowerCase()) + getWordWeight(words.get(i + 1).toLowerCase());

            if (currentSum >= maxSum){
                maxSum = currentSum;
                output = String.format("%s\n%s", words.get(i), words.get(i + 1));
            }
        }
        System.out.println(output);

    }

    public static int getWordWeight(String word){

        int weight = 0;

        for (int i = 0; i < word.length(); i++) {
            weight += (int)word.charAt(i) - 96;
        }

        return weight;
    }
}
