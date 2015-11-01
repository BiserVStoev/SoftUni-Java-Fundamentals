package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_TinySporebat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int health = 5_800;
        int glowCaps = 0;

        Pattern pattern = Pattern.compile("(.+)(\\d+)");

        while (!input.equals("Sporeggar")){


            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){

                for (int i = 0; i < matcher.group(1).length(); i++) {
                    if (matcher.group(1).charAt(i) == 'L'){
                        health += 200;
                    }else{
                        health -= (int)matcher.group(1).charAt(i);
                        if (health <= 0){
                            System.out.println("Died. Glowcaps: " + glowCaps);
                            return;
                        }
                    }
                }
                glowCaps += Integer.parseInt(matcher.group(2));
            }

            input = scanner.nextLine();
        }

        System.out.println("Health left: " + health);
        if (glowCaps >= 30){
            System.out.printf("Bought the sporebat. Glowcaps left: %d", glowCaps - 30);
        }else{
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowCaps);
        }
    }
}
