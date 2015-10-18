package com.company;

import java.util.Random;
import java.util.Scanner;

public class _07_RandomizeNumbersFromNToM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number N: ");
        int n = scanner.nextInt();

        System.out.print("Enter number M: ");
        int m = scanner.nextInt();

        if (n > m){
            int temp = n;
            n = m;
            m = temp;
        }

        if (n != m){
            for (int i = 0; i <= m - n; i++) {
                Random rn = new Random();

                int rndNumber = n + rn.nextInt(m - n + 1);

                System.out.print(rndNumber + " ");

            }
        }else{
            System.out.println(n);
        }

    }
}
