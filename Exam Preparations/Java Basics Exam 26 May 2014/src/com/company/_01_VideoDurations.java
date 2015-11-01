package com.company;

import java.util.Scanner;

public class _01_VideoDurations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int totalTime = 0;
        while(!input.equals("End")){

            String[] time = input.split(":");

            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);

            totalTime += hours*60 + minutes;

            input = scanner.nextLine();
        }

        System.out.printf("%d:%02d", totalTime / 60, totalTime % 60);
    }
}
