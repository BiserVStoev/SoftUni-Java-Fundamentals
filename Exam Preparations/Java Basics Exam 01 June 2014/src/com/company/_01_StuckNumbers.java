package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_StuckNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Integer[] input = new Integer[n];
        for (int i = 0; i < input.length; i++) {
            input[i ]= scanner.nextInt();
        }

        List<String> numbers = new ArrayList<>();

        for (Integer integer : input){
            numbers.add(integer.toString());
        }

        List<String> output = new ArrayList<>();

        for (String a : numbers){
            for (String b : numbers){
                for (String c : numbers){
                    for (String d : numbers){
                        if ((!a.equals(b) && (!a.equals(c)) && (!a.equals(d)) && (!b.equals(c)) && (!b.equals(d)) && (!c.equals(d)))){
                            if ((a + b).equals(c + d)){

                                output.add(String.format("%s|%s==%s|%s", a, b, c, d));
                            }
                        }
                    }
                }
            }
        }

        if (output.size() > 0)
        {
            for (String stuck : output)
            System.out.println(stuck);
        }
        else
        {
            System.out.println("No");
        }

    }
}
