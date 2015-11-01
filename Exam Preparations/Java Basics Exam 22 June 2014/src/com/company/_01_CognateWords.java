package com.company;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_CognateWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        Matcher matcher = pattern.matcher(input);

        ArrayList<String> words = new ArrayList<>();

        while (matcher.find()){
            words.add(matcher.group());
        }

        LinkedHashSet<String> uniqueOutput = new LinkedHashSet<>();

        for (int a = 0; a < words.size(); a++) {
            for (int b = 0; b < words.size(); b++) {
                for (int c = 0; c < words.size(); c++) {
                    if (a != b){
                        if ((words.get(a) + words.get(b)).equals(words.get(c))){
                            uniqueOutput.add(String.format("%s|%s=%s", words.get(a), words.get(b), words.get(c)));
                        }
                    }

                }
            }
        }

        if (uniqueOutput.size() != 0){
            for (String output : uniqueOutput){
                System.out.println(output);
            }
        }else{
            System.out.println("No");
        }
    }
}
