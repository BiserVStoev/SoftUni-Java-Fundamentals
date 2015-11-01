package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_GandalfsStash {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int moodPoints = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine().toLowerCase().replaceAll("_", "");

        Pattern pattern = Pattern.compile("[a-zA-z]+");

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){

            moodPoints += getMoodPoints(matcher.group());

        }

        System.out.println(moodPoints);
        System.out.println(getMood(moodPoints));

    }

    public static int getMoodPoints(String word){

        int points = 0;

        switch (word){
            case "cram": points = 2;
                break;
            case "lembas": points = 3;
                break;
            case "apple": points = 1;
                break;
            case "melon": points = 1;
                break;
            case "honeycake": points = 5;
                break;
            case "mushrooms": points = -10;
                break;
            default: points = -1;
                break;
        }

        return points;
    }

    public static String getMood (int moodPoints){

        if (moodPoints < -5){

            return "Angry";
        }else if (moodPoints >= -5 && moodPoints < 0){

            return "Sad";
        }else if (moodPoints >= 0 && moodPoints < 15){

            return  "Happy";
        }else {

            return "Special JavaScript mood";
        }
    }
}
