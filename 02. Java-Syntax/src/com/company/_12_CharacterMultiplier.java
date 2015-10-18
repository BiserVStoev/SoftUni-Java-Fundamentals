package com.company;

import java.util.Scanner;

public class _12_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two strings: ");
        String[] input = scanner.nextLine().split(" ");

        int total = getSumOfCharacterCodes(input[0], input[1]);

        System.out.print("Strings multiplied value: ");
        System.out.println(total);
    }

    public static int getSumOfCharacterCodes(String firsStr, String secondStr){
        int total = 0;
        int maxLength = Math.max(firsStr.length(), secondStr.length());

        for (int i = 0; i < maxLength; i++) {

            if ( firsStr.length() > i && secondStr.length() > i){
                int firstStrValue = (int)(firsStr.charAt(i));
                int secondStrValue = (int)(secondStr.charAt(i));

                total += firstStrValue * secondStrValue;
            }else if (firsStr.length() <= i){
                total += (int)(secondStr.charAt(i));
            }else{
                total += (int)(firsStr.charAt(i));
            }

        }

        return total;
    }
}
