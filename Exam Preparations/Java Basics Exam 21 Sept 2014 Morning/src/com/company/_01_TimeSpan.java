package com.company;

import java.util.Scanner;

public class _01_TimeSpan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split(":");

        String[] input2 = scanner.nextLine().split(":");

        long startTotalSeconds = Long.parseLong(input1[0]) * 3600 + Long.parseLong(input1[1]) * 60 + Long.parseLong(input1[2]);
        long endTotalSeconds = Long.parseLong(input2[0]) * 3600 + Long.parseLong(input2[1]) * 60 + Long.parseLong(input2[2]);

        long timeSpan = startTotalSeconds - endTotalSeconds;

        System.out.printf("%d:%02d:%02d", timeSpan / 3600, (timeSpan % 3600) / 60, (timeSpan % 3600) % 60 );
    }
}
