package com.company;

import java.util.Scanner;

public class _09_HitTheTarget {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == number){
                    System.out.println(i + " + " + j + " = " + number) ;
                }

                if (i - j == number){
                    System.out.println(i + " - " + j + " = " + number) ;
                }
            }
        }
    }
}
