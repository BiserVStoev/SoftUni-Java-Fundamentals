package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class _04_ActivityTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        TreeMap<Integer, TreeMap<String, Integer>> activity = new TreeMap<>();

        String[] data;

        int month = 0;
        String name = "";
        int distance = 0;

        for (int i = 0; i < count; i++) {
            data = scanner.nextLine().split(" ");

            month = Integer.parseInt(data[0].substring(3,5));
            name = data[1];
            distance = (Integer.parseInt(data[2]));

            if (!activity.containsKey(month)){
                activity.put(month, new TreeMap<>());
                activity.get(month).put(name, distance);
            }else{
                if (activity.get(month).get(name) == null){
                    activity.get(month).put(name, distance);
                }else {
                    int updatedDistance = activity.get(month).get(name) + distance;
                    activity.get(month).put(name, updatedDistance);
                }
            }
        }

        for (Integer outputMonth : activity.keySet()){
            System.out.print(outputMonth + ": ");

            String output = "";
            for (String outputName : activity.get(outputMonth).keySet()){
                output += outputName + "(" + activity.get(outputMonth).get(outputName) + ")" + ", ";
            }
            System.out.println(output.substring(0, output.length() - 2));
        }
    }
}
