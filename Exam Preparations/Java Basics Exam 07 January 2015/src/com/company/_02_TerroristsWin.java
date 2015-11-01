package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_TerroristsWin {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern patter = Pattern.compile("\\|.*?\\|");

        Matcher matcher = patter.matcher(input.toString());

        char[] bombarded = input.toCharArray();

        while (matcher.find()){

            int currentBombIndex = input.indexOf(matcher.group());

            int bombPower = 0;

            for (Character ch : matcher.group().replaceAll("\\|", "").toCharArray()){
                bombPower += (int)ch;

            }

            bombPower %=10;

            for (int i = currentBombIndex - bombPower; i < currentBombIndex + matcher.group().length() + bombPower ; i++) {
                if (i >= 0 && i < input.length()){
                    bombarded[i] = '.';

                    StringBuilder sb = new StringBuilder();
                    for (Character ch : bombarded){
                        sb.append(ch);
                    }

                    input = sb.toString();
                }
            }

        }

        System.out.println(bombarded);
    }
}
