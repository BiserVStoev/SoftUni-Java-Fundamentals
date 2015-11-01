package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03_LegoBlocks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] firstJaggedArrays = new String[n][];
        String[][] secondJaggedArrays = new String[n][];

        for (int i = 0; i < n; i++) {
            firstJaggedArrays[i] =  scanner.nextLine().trim().split("\\s+");
        }

        for (int i = 0; i < n; i++) {
            secondJaggedArrays[i] = scanner.nextLine().trim().split("\\s+");
        }
        String[][] combinedArrays = new String[n][];

        int counter = 1;
        for (int i = 0; i < n; i++) {
            combinedArrays[i] = new String[firstJaggedArrays[i].length + secondJaggedArrays[i].length];
            for (int j = 0; j <firstJaggedArrays[i].length ; j++) {
                combinedArrays[i][j] = firstJaggedArrays[i][j];
            }
            for (int j = firstJaggedArrays[i].length ; j < combinedArrays[i].length ; j++) {
                combinedArrays[i][j] = secondJaggedArrays[i][secondJaggedArrays[i].length - counter];
                counter++;
            }
            counter = 1;
        }

        int firstArrayLength = combinedArrays[0].length;

        int numberOfCells = 0;

        for (int i = 0; i < combinedArrays.length; i++) {
            numberOfCells += combinedArrays[i].length;
        }
        for (int i = 1; i < combinedArrays.length; i++) {
            if (combinedArrays[i].length != firstArrayLength){

                System.out.printf("The total number of cells is: %d", numberOfCells);
                return;
            }
        }

        for (int i = 0; i < combinedArrays.length; i++) {
            System.out.println(Arrays.asList(combinedArrays[i]));
        }
    }
}
