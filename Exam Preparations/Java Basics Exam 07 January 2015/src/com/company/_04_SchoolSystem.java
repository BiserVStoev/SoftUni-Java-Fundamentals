package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_SchoolSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        String[] input = new String[4];


        TreeMap<String, TreeMap<String, List<Integer>>> scores = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            input = scanner.nextLine().split("\\s+");

            String name = input[0] + " " + input[1];
            String subject = input[2];
            int currentScore = Integer.parseInt(input[3]);

            if (!scores.containsKey(name)){
                scores.put(name, new TreeMap<>());
                scores.get(name).put(subject, new ArrayList<>());
                List<Integer> subjectScores = scores.get(name).get(subject);
                subjectScores.add(currentScore);
                scores.get(name).put(subject, subjectScores);
            }else if (scores.get(name).get(subject) == null){
                scores.get(name).put(subject, new ArrayList<>());
                List<Integer> subjectScores = scores.get(name).get(subject);
                subjectScores.add(currentScore);
                scores.get(name).put(subject, subjectScores);
            }else{
                List<Integer> subjectScores = scores.get(name).get(subject);
                subjectScores.add(currentScore);

            }


        }
        for (String person : scores.keySet()){
            System.out.printf(person + ": [");

            String grades = "";
            for (String subject: scores.get(person).keySet()){

                double grade = scores.get(person).get(subject).stream().mapToInt(i -> i).average().getAsDouble();

                grades += String.format("%s - %.2f, ", subject, grade);
            }
            System.out.println(grades.substring(0, grades.length() - 2) + "]");
        }
    }
}
