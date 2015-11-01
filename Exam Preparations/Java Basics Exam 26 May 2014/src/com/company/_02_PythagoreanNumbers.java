package com.company;

import java.util.Scanner;

public class _02_PythagoreanNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Integer[] nums = new Integer[count];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        boolean found = false;

        for (Integer a : nums){
            for (Integer b : nums){
                for (Integer c : nums){
                    if (a <= b &&  (a * a) + (b * b) == (c * c)){
                        System.out.printf("%d*%d + %d*%d = %d*%d\n", a, a, b, b, c, c);
                        found = true;
                    }
                }
            }
        }

        if (!found){
            System.out.println("No");
        }
    }
}
