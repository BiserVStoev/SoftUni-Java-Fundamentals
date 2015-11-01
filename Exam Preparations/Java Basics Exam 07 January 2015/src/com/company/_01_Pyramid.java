package com.company;

import java.util.Scanner;

public class _01_Pyramid {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        Integer[][] pyramid = new Integer[rows][];

        for (int i = 0; i < rows; i++) {

            String[] input = scanner.nextLine().trim().split("\\s+");
            pyramid[i] = putNumsInPyramid(input);
        }

        StringBuilder output = new StringBuilder();

        int num = pyramid[0][0];

        output.append(num + ", ");

        int currentNum = 0;

        int currentBiggestComparator = Integer.MAX_VALUE;

        int toGet = num;

        int previousNum = num;

        for (int i = 1; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                currentNum = pyramid[i][j];

                if (currentNum > num && currentNum < currentBiggestComparator){
                    currentBiggestComparator = currentNum;
                    toGet = currentNum;
                }

            }

            if (num != toGet){
                num = toGet;
                if (num == previousNum){
                    num++;
                }else if (num == previousNum - 1){
                    num += 2;
                }else{
                    output.append(num + ", ");
                }
            }


            currentBiggestComparator = Integer.MAX_VALUE;
            if (previousNum < num){
                previousNum = num;
            }
        }
        System.out.println(output.toString().substring(0, output.length() - 2));
    }

    public static Integer[] putNumsInPyramid(String[] input){
        Integer[] nums = new Integer[input.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);

        }

        return nums;
    }
}
