package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_ValidUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll("[ \\/\\\\)(]+", " ").trim();

        Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w_]{3,25}\\b");

        Matcher matcher = pattern.matcher(input);


        List<String> matches = new ArrayList<>();

        while (matcher.find()){
            matches.add(matcher.group());
        }

        String toPrint = "";

        int maxSum = 0;

        for (int i = 1; i < matches.size(); i++) {

            String previousMatch = matches.get(i - 1);
            String currentMatch = matches.get(i);

            int sum = previousMatch.length() + currentMatch.length();

            if (sum > maxSum){
                maxSum = sum;
                toPrint = previousMatch + "\n" + currentMatch;
            }
        }

        System.out.println(toPrint);
    }
}
