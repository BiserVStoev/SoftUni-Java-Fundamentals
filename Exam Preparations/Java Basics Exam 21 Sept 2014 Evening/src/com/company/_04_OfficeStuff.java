package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_OfficeStuff {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        TreeMap<String, LinkedHashMap<String, Integer>> officeStuff = new TreeMap<>();


        for (int i = 0; i < lines; i++) {

            String[] input = scanner.nextLine().split("[ \\|-]+");

            String company = input[1];
            String product = input[3];
            int amount = Integer.parseInt(input[2]);

            if (!officeStuff.containsKey(company)){
                officeStuff.put(company, new LinkedHashMap<>());
                officeStuff.get(company).put(product, amount);
            }else if (officeStuff.get(company).get(product) == null){
                officeStuff.get(company).put(product, amount);
            }else {
                int previousAmount = officeStuff.get(company).get(product);
                officeStuff.get(company).put(product, previousAmount + amount);
            }
        }

        for (String company : officeStuff.keySet()){
            System.out.print(company + ": ");
            String output = "";

            for (String product : officeStuff.get(company).keySet()){
             output += String.format("%s-%d, ", product, officeStuff.get(company).get(product));
            }
            System.out.println(output.substring(0, output.length() - 2));
        }
    }
}
