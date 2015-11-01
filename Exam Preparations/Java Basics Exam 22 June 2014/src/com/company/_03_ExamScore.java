package com.company;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class _03_ExamScore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input;

        for (int i = 0; i < 3; i++) {
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        TreeMap<Integer, TreeMap<String, Double>> examScores = new TreeMap<>();

        int examScore = 0;
        String student = "";
        double grade = 0;

        Pattern pattern = Pattern.compile("([A-Z][a-z]+\\s[A-Z][a-z]+)\\s+\\|\\s(\\d+)\\s+\\|\\s(\\d\\.\\d+)");

        while (true){
            String[] tester = input.split("-");
            if (tester.length == 0){
                break;
            }

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                student = matcher.group(1);
                examScore = Integer.parseInt(matcher.group(2));
                grade = Double.parseDouble(matcher.group(3));
            }

            if (!examScores.containsKey(examScore)){
                examScores.put(examScore, new TreeMap<>());
                examScores.get(examScore).put(student, grade);
            }else if (examScores.get(examScore).get(student) == null) {
                examScores.get(examScore).put(student, grade);
            }

            input = scanner.nextLine();
        }

        for (Integer score : examScores.keySet()){
            System.out.printf("%d -> [", score);
            String currentNames = "";
            double average = 0;
            int numberOfGrades = 0;
            for (String name : examScores.get(score).keySet()){
                currentNames += name + ", ";
                numberOfGrades++;
                average += examScores.get(score).get(name);
            }
            currentNames = currentNames.substring(0, currentNames.length() - 2);
            System.out.printf("%s]; avg=%.2f\n", currentNames, average / numberOfGrades);
        }
        System.out.println();
    }
}
