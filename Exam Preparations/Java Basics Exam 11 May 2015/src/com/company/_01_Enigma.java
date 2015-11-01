package com.company;

import java.util.Scanner;

public class _01_Enigma {
    public static void main(String[] args) {

        final String notDecrypted = " 0123456789";

        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());



        for (int i = 0; i < numberOfLines; i++) {
            String currentStr = scanner.nextLine();

            StringBuilder sb = new StringBuilder();

            int messageLength = currentStr.replaceAll("\\s+", "").toCharArray().length / 2;

            for (char ch : currentStr.toCharArray()){
                if (!notDecrypted.contains(ch + "")){
                    char cha = (char)((int)ch + messageLength);
                    sb.append((char)((int)ch + messageLength));
                }else{
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
