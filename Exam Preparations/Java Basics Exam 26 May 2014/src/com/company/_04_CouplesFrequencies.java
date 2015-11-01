package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CouplesFrequencies {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] allNums = scanner.nextLine().split(" ");

        String[] couples = new String[allNums.length - 1];;

        for (int i = 0; i < couples.length; i++) {
            couples[i] = allNums[i] + " " + allNums [i + 1];
        }

        double numberOfCouples = couples.length;

        LinkedHashMap<String, Integer> couplesFrequencies = new LinkedHashMap<>();

        for (int i = 0; i < couples.length; i++) {
            if (!couplesFrequencies.containsKey(couples[i])){
                couplesFrequencies.put(couples[i], 1);
            }else{
                int currentOccurences = couplesFrequencies.get(couples[i]);
                couplesFrequencies.put(couples[i], currentOccurences + 1);
            }
        }

        for (String couple : couplesFrequencies.keySet()){
            System.out.printf("%s -> %.2f%%\n", couple, (couplesFrequencies.get(couple) / numberOfCouples) * 100);

        }
    }
}
