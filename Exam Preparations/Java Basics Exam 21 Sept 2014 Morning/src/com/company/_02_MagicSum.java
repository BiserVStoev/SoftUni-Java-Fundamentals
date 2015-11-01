package com.company;

import java.util.*;

public class _02_MagicSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int d = Integer.parseInt(scanner.nextLine());

        List<Integer> nums = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){

            nums.add(Integer.parseInt(input));

            input = scanner.nextLine();

        }

        int maxSum = Integer.MIN_VALUE;

        String output = "";
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                for (int k = j + 1; k < nums.size(); k++) {
                    if ( i != j && i != k && j != k){
                        if ((nums.get(i) + nums.get(j) + nums.get(k)) % d == 0){
                            int currentSum = nums.get(i) + nums.get(j) + nums.get(k);

                            if (currentSum > maxSum){
                                maxSum = currentSum;
                                output = String.format("(%d + %d + %d) %% %d = 0", nums.get(i), nums.get(j), nums.get(k), d);
                            }
                        }
                    }
                }
            }

        }

        if (!output.equals("")){
            System.out.println(output);
        }else{
            System.out.println("No");
        }
    }
}
