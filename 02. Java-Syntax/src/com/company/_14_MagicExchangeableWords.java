package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _14_MagicExchangeableWords {
    public static void main(String[] args) {
        System.out.print("Enter two strings of equal length: ");

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String firstStr = input[0];
        String secondStr = input[1];

        boolean exchangeable = true;

        Map<Character,Character> exchangeableKeys = new HashMap<>();

        for (int i = 1; i < firstStr.length(); i++) {
            char currentCharFirst = firstStr.charAt(i);
            char currentCharSecond = secondStr.charAt(i);

            if (exchangeableKeys.containsKey(currentCharFirst)){
                if (exchangeableKeys.get(currentCharFirst) != currentCharSecond){
                    exchangeable = false;
                    System.out.println(exchangeable);
                    return;
                }
            }else{
                if (exchangeableKeys.containsValue(currentCharSecond)){
                    exchangeable = false;
                    System.out.println(exchangeable);
                    return;
                }
                exchangeableKeys.put(currentCharFirst, currentCharSecond);
            }
        }
        System.out.println(exchangeable);
    }
}
