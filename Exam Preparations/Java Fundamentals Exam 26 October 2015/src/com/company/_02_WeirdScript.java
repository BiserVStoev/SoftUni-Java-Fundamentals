package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_WeirdScript {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine()) % 52;

        String keyletter = "";

        if (num == 0){
            keyletter = Character.toString((char)(90)) + Character.toString((char)(90));
        }else if (num < 27){
            keyletter = Character.toString((char)(96 + num)) + Character.toString((char)(96 + num));
        }else{
            if (num != 52){
                keyletter = Character.toString((char)(64 + num - 26)) + Character.toString((char)(64 + num - 26));
            }
        }

        StringBuilder sb = new StringBuilder();

        String input = "";

        while (!input.equals("End")){

            sb.append(input);

            input = scanner.nextLine();
        }


        Pattern pattern = Pattern.compile(keyletter + "(.*?){0,50}" + keyletter);

        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()){

            System.out.println(matcher.group(1));
        }

    }
}
