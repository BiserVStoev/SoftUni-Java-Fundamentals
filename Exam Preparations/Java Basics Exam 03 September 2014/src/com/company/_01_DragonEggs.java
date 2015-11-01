package com.company;

import java.util.Scanner;

public class _01_DragonEggs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = new String[2];

        int allEggs = 0;

        for (int i = 0; i < 7; i++) {
            input = scanner.nextLine().split(" ");

            int count = Integer.parseInt(input[0]);
            if (input[1].equals("dozens")){
                count = count * 12;
            }

            allEggs += count;
        }

        int dozens = allEggs / 12;
        int eggs = allEggs % 12;

        System.out.printf("%d dozens + %d eggs", dozens, eggs);
    }
}
