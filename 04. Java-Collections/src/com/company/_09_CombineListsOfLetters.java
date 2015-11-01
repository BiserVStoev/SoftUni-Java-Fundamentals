package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that reads two lists of letters l1 and l2 and combines them: appends all letters c from l2 to the end of l1, but only when c does not appear in l1.
 * Print the obtained combined list. All lists are given as sequence of letters separated by a single space, each at a separate line.
 * Use ArrayList<Character> of chars to keep the input and output lists.
 */

public class _09_CombineListsOfLetters {
    public static void main(String[] args) {
        System.out.print("Enter the first list of letter: ");

        Scanner scanner = new Scanner(System.in);
        char[] firstInput = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

        System.out.print("Enter the second list of letter: ");
        char[] secondInput = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

        ArrayList<Character> l1 = new ArrayList<>();

        for (int i = 0; i < firstInput.length; i++) {
            l1.add(firstInput[i]);
        }

        ArrayList<Character> l2 = new ArrayList<>();

        for (int i = 0; i < secondInput.length ; i++) {
            l2.add(secondInput[i]);
        }

        ArrayList<Character> output = new ArrayList<>();

        for (Character character : l1){
            output.add(character);
        }

        for (Character character : l2){
            if (!l1.contains(character)){
                output.add(character);
            }
        }

        System.out.print("Combined list: ");
        for (Character character : output) {
            System.out.print(character + " ");
        }
    }
}
