package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Orders {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, Integer>> orders = new LinkedHashMap<>();

        String[] input;
        String customer;
        int amount;
        String product;

        for (int i = 0; i < count; i++) {

            input = scanner.nextLine().split(" ");

            customer = input[0];
            amount = Integer.parseInt(input[1]);
            product = input[2];

            if (!orders.containsKey(product)){
                orders.put(product, new TreeMap<>());
                orders.get(product).put(customer, amount);
            }else if (orders.get(product).get(customer) == null){
                orders.get(product).put(customer, amount);
            }else{
                int currentAmount = orders.get(product).get(customer);
                orders.get(product).put(customer, currentAmount + amount);
            }
        }

        for (String prod : orders.keySet()){
            System.out.print(prod + ": ");
            String value = "";
            for (String person : orders.get(prod).keySet()){
                value += String.format("%s %d, ", person, orders.get(prod).get(person));
            }
            System.out.println(value.substring(0, value.length() - 2));
        }
    }
}
