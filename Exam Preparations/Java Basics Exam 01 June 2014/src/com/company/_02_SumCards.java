package com.company;

import java.util.Scanner;
public class _02_SumCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().split(" ");

        int sum = 0;



        if (cards.length == 1){
            String firstCard = "";
            if (cards[0].length() == 2){
                firstCard = cards[0].substring(0, 1);
            }else{
                firstCard = cards[0].substring(0, 2);
            }
            System.out.println(cardValue(firstCard, 1));
            return;
        }
        for (int i = 0; i < 1; i++) {
            String firstCard = "";
            if (cards[i].length() == 2){
                firstCard = cards[i].substring(0, 1);
            }else{
                firstCard = cards[i].substring(0, 2);
            }

            String secondCard = "";

            if (cards[i + 1].length() == 2){
                secondCard = cards[i + 1].substring(0, 1);
            }else{
                secondCard = cards[i + 1].substring(0, 2);
            }

            int multiplier = 1;
            if (firstCard.equals(secondCard)){
                multiplier = 2;
            }

            sum += cardValue(firstCard, multiplier);
        }

        for (int i = 1; i < cards.length - 1; i++) {

            String previousCard = "";
            if (cards[i-1].length() == 2){
                previousCard = cards[i - 1].substring(0, 1);
            }else{
                previousCard = cards[i - 1].substring(0, 2);
            }

            String card = "";

            if (cards[i].length() == 2){
                card = cards[i].substring(0, 1);
            }else{
                card = cards[i].substring(0, 2);
            }

            String nextCard = "";

            if (cards[i + 1].length() == 2){
                nextCard = cards[i + 1].substring(0, 1);
            }else{
                nextCard = cards[i + 1].substring(0, 2);
            }


            int multiplier = 1;
            if (previousCard.equals(card) || card.equals(nextCard)){
                multiplier = 2;
            }

            sum += cardValue(card, multiplier);

        }

        for (int i = cards.length - 1; i < cards.length; i++) {
            String previousCard = "";
            if (cards[i - 1].length() == 2){
                previousCard = cards[i - 1].substring(0, 1);
            }else{
                previousCard = cards[i - 1].substring(0, 2);
            }

            String lastCard = "";

            if (cards[i].length() == 2){
                lastCard = cards[i].substring(0, 1);
            }else{
                lastCard = cards[i].substring(0, 2);
            }

            int multiplier = 1;
            if (previousCard.equals(lastCard)){
                multiplier = 2;
            }

            sum += cardValue(lastCard, multiplier);
        }

        System.out.println(sum);
    }

    public static int cardValue(String card, int multiplier){
        int value = 0;
        switch (card){
            case "2": value = 2;
                break;
            case "3": value = 3;
                break;
            case "4": value = 4;
                break;
            case "5": value = 5;
                break;
            case "6": value = 6;
                break;
            case "7": value = 7;
                break;
            case "8": value = 8;
                break;
            case "9": value = 9;
                break;
            case "10": value = 10;
                break;
            case "J": value = 12;
                break;
            case "Q": value = 13;
                break;
            case "K": value = 14;
                break;
            case "A": value = 15;
                break;
        }
        return value * multiplier;
    }
}
