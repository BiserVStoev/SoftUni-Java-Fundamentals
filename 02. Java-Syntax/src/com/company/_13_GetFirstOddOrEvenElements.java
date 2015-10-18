package com.company;

import java.util.Scanner;

public class _13_GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        System.out.print("Enter array of numbers: ");

        Scanner scanner = new Scanner(System.in);

        String[] arrayOfNumbersAsStr = scanner.nextLine().split(" ");

        int[] numbers = new int[arrayOfNumbersAsStr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arrayOfNumbersAsStr[i]);
        }

        System.out.print("Enter command: ");
        String[] command = scanner.nextLine().split(" ");

        getFirstElements(numbers, Integer.parseInt(command[1]), command[2]);


    }

    public static void getFirstElements(int[] numbers, int count, String type){
        int counter = 0;

        for (int i = 0; i < numbers.length ; i++) {
            if (type.equals("odd") && numbers[i] % 2 == 1){
                if (counter == count){
                    return;
                }
                counter++;
                System.out.print(numbers[i] + " ");
            }else if (type.equals("even")&& numbers[i] % 2 == 0){
              if (counter == count){
                  return;
              }
              counter++;
              System.out.print(numbers[i] + " ");

            }
        }
    }
}
