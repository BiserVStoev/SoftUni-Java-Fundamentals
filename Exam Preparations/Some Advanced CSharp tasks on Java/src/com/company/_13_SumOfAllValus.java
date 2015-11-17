package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_SumOfAllValus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        String textString = scanner.nextLine();

        Pattern keyStartPat = Pattern.compile("^[a-zA-Z_]+(?=\\d+|\\d+\\.\\d+)");
        Pattern keyEndPat = Pattern.compile("(?<=\\d|\\d\\.\\d)[a-zA-Z_]+$");

        Matcher matcher = keyStartPat.matcher(keyString);
        Matcher endMatcher = keyEndPat.matcher(keyString);

        boolean keyFound = false;

        String startKey = "";
        String endKey = "";
        while (matcher.find()){

            startKey = matcher.group();;
        }

        while (endMatcher.find()){
            endKey = endMatcher.group();
        }

        double sum = 0;

        if (!startKey.equals("") && !endKey.equals("")){
            keyFound = true;

            Pattern secondPattern = Pattern.compile(startKey + "(\\d+|\\d+\\.\\d+|\\.\\d+)" + endKey);

            Matcher secondMatch = secondPattern.matcher(textString);

            while (secondMatch.find()){
                sum += Double.parseDouble(secondMatch.group(1));
            }

        }

        if (keyFound){
            if (sum == 0){
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }else{
                if (sum == (int)sum){
                    System.out.printf("<p>The total value is: <em>%d</em></p>\n", (int)sum);
                }else{
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>\n", sum);
                }

            }
        }else {
            System.out.println("<p>A key is missing</p>");
        }



    }
}
