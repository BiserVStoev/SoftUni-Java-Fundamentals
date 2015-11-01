package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class _04_Weightlifting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Long>> liftingData = new TreeMap<>();

        for (int i = 0; i < length; i++) {

            String[] currentInput = scanner.nextLine().split(" ");

            String firstName = currentInput[0];
            String exercise = currentInput[1];
            long weight = Integer.parseInt(currentInput[2]);

            if (!liftingData.containsKey(firstName)){
                liftingData.put(firstName, new TreeMap<>());
                liftingData.get(firstName).put(exercise, weight);
            }else if (liftingData.get(firstName).get(exercise) == null){
                liftingData.get(firstName).put(exercise, weight);
            }else{
                long currentWeight = liftingData.get(firstName).get(exercise);
                liftingData.get(firstName).put(exercise, currentWeight + weight);
            }
        }

        for (String person : liftingData.keySet()){

            System.out.printf("%s : ", person);
            String weights = "";
            for (String exercise : liftingData.get(person).keySet()){

                weights += String.format("%s - %d kg, ", exercise, liftingData.get(person).get(exercise));
            }

            System.out.println(weights.substring(0, weights.length() - 2));
        }
    }
}
