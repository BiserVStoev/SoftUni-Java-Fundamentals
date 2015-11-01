package com.company;

import java.util.*;

public class _02_PossibleTriangles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean makesTriangle = false;

        while (!input.equals("End")){

            String[] nums = input.split(" ");

            List<Double> numbers = new ArrayList<>();

            for (String num : nums){
                numbers.add(Double.parseDouble(num));
            }

            Collections.sort(numbers);

            if (numbers.get(0) + numbers.get(1) > numbers.get(2)){
                System.out.printf("%.2f+%.2f>%.2f\n", numbers.get(0), numbers.get(1), numbers.get(2));
                makesTriangle = true;
            }

            input = scanner.nextLine();
        }

        if (!makesTriangle){
            System.out.println("No");
        }
    }
}
