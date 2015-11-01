package com.company;

import java.util.Scanner;

public class _01_MirrorNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        String[] numbers = scanner.nextLine().split(" ");

        boolean hasNums = false;


        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (numbers[i].equals(new StringBuilder(numbers[j]).reverse().toString())){
                    System.out.printf("%s<!>%s\n", numbers[i], numbers[j]);
                    hasNums = true;
                }
            }
        }

        if (!hasNums){
            System.out.println("No");
        }
    }
}
