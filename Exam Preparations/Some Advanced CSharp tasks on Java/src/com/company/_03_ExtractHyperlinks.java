package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_ExtractHyperlinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("<a\\s+(?:[^>]+\\s+)?href\\s*=\\s*(?:'([^']*)'|\"\"([^\"\"]*)\"\"|([^\\s>]+))[^>]*>");

        StringBuilder sb = new StringBuilder();

        while (!input.equals("END")){
            sb.append(input);
            input = scanner.nextLine();
        }

        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()){
            for (int i = 1; i <= 3; i++) {
                if (matcher.group(i) != null) {
                    System.out.println(matcher.group(i).replaceAll("\"", ""));
                }
            }
        }
    }
}
