package com.company;

import java.util.Scanner;

public class _02_AddingAngles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        boolean exists = false;

        Integer[] numbers = new Integer[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int a = 0; a < numbers.length; a++) {
            for (int b = a + 1; b < numbers.length; b++) {
                for (int c = b + 1; c < numbers.length; c++) {
                    if ((numbers[a] + numbers[b] + numbers[c]) % 360 == 0){
                        exists = true;
                        System.out.printf("%d + %d + %d = %d degrees\n",numbers[a] , numbers[b], numbers[c], numbers[a] + numbers[b] + numbers[c]);
                    }
                }
            }
        }

        if (!exists){
            System.out.println("No");
        }
    }

}
