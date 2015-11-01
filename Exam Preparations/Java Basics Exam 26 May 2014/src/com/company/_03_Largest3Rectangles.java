package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03_Largest3Rectangles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inpuut = scanner.nextLine().replaceAll("\\[", " ").replaceAll("\\s+", "").trim();
        String[] input = inpuut.split("]");

        String[] firstRectangleSplit;
        String[] secondRectangleSplit;
        String[] thirdRectangleSplit;

        int firstRectangle = 0;
        int secondRectangle = 0;
        int thirdRectangle = 0;
        int sum = 0;

        String largest3Rectangles = "";

        for (int i = 0; i < input.length - 2; i++) {

            int currentSum = 0;

            firstRectangleSplit = input[i].split("x");
            secondRectangleSplit = input[i + 1].split("x");
            thirdRectangleSplit = input[i + 2].split("x");

            firstRectangle = Integer.parseInt(firstRectangleSplit[0]) * Integer.parseInt(firstRectangleSplit[1]);
            secondRectangle = Integer.parseInt(secondRectangleSplit[0]) * Integer.parseInt(secondRectangleSplit[1]);
            thirdRectangle = Integer.parseInt(thirdRectangleSplit[0]) * Integer.parseInt(thirdRectangleSplit[1]);

            currentSum = firstRectangle + secondRectangle + thirdRectangle;

            if (currentSum > sum){
                sum = currentSum;
                largest3Rectangles = i + " " + (i + 1) + " " + (i + 2);
            }
        }

        String[] indexHolder = largest3Rectangles.split(" ");

        String[] largestFirstRectangle = input[Integer.parseInt(indexHolder[0])].split("x");
        String[] largestSecondRectangle = input[Integer.parseInt(indexHolder[1])].split("x");
        String[] largestThirdRectangle = input[Integer.parseInt(indexHolder[2])].split("x");

        System.out.println(sum);

    }
}
