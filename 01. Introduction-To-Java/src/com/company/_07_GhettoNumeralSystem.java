package com.company;

import java.util.Scanner;

public class _07_GhettoNumeralSystem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write the number you want to convert to Ghetto numeral system:");

        String number = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            getNumInGhettoNumeralSystem(number, sb, i);
        }

        System.out.print("Ghetto num: ");
        System.out.println(sb.toString());
    }

    public static void getNumInGhettoNumeralSystem(String number, StringBuilder sb, int i) {
        switch (number.charAt(i)){
            case '0':
                sb.append("Gee");
                break;
            case '1':
                sb.append("Bro");
                break;
            case '2':
                sb.append("Zuz");
                break;
            case '3':
                sb.append("Ma");
                break;
            case '4':
                sb.append("Duh");
                break;
            case '5':
                sb.append("Yo");
                break;
            case '6':
                sb.append("Dis");
                break;
            case '7':
                sb.append("Hood");
                break;
            case '8':
                sb.append("Jam");
                break;
            case '9':
                sb.append("Mack");
                break;
        }
    }
}
