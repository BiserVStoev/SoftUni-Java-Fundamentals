package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Nuts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        TreeMap<String, LinkedHashMap<String, Integer>> nuts = new TreeMap<>();


        for (int i = 0; i < lines; i++) {

            String[] input = scanner.nextLine().split(" ");

            String company = input[0];
            String nut = input[1];
            int amount = Integer.parseInt(input[2].replace("kg", ""));

            if (!nuts.containsKey(company)){
                nuts.put(company, new LinkedHashMap<>());
                nuts.get(company).put(nut, amount);
            }else if (nuts.get(company).get(nut) == null){
                nuts.get(company).put(nut, amount);
            }else {
                int previousAmount = nuts.get(company).get(nut);
                nuts.get(company).put(nut, previousAmount + amount);
            }
        }

        for (String company : nuts.keySet()){
            System.out.print(company + ": ");
            String output = "";

            for (String nut : nuts.get(company).keySet()){
                output += String.format("%s-%dkg, ", nut, nuts.get(company).get(nut));
            }
            System.out.println(output.substring(0, output.length() - 2));
        }
    }
}
