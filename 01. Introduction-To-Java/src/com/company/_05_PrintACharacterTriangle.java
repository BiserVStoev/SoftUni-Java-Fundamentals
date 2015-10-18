package com.company;
import java.util.Scanner;

public class _05_PrintACharacterTriangle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter num: ");
        int input = scanner.nextInt();

        char startChar = 'a';

        for (int i = 1; i <= input; i++) {
            for (int j = 0; j < i; j++) {

                System.out.print((char)(97+ j)+ " ");
            }
            System.out.println();
        }

        for (int i = input - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {

                System.out.print((char)(97+ j)+ " ");
            }
            System.out.println();
        }
    }
}
