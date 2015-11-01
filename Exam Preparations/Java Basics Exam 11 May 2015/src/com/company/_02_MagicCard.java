package com.company;

import java.util.Scanner;

public class _02_MagicCard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().split("\\s+");

        String type = scanner.nextLine();

        String magicCard = scanner.nextLine();

        int typeDeterminer = 0;
        if (type.equals("odd")){
            typeDeterminer = 1;
        }

        int magicCardLength = 0;
        if (magicCard.length() > 2){
            magicCardLength = 1;
        }

        String magicCardFace = magicCard.substring(0, 1 + magicCardLength);
        String magicCardBack = magicCard.substring(1 + magicCardLength);

        int sum = 0;

        for (int i = 0; i < cards.length; i++) {

            if (i % 2 == typeDeterminer){
                int currentCardValue = getCardValue(cards[i]);

                int cardLength = 0;
                if (cards[i].length() > 2){
                    cardLength = 1;
                }

                String cardFace = cards[i].substring(0,1 + cardLength);
                String cardBack = cards[i].substring(1 + cardLength);


                if (cardFace.equals(magicCardFace)){
                    currentCardValue *= 3;
                }else if (cardBack.equals(magicCardBack)){
                    currentCardValue *= 2;
                }
                sum += currentCardValue;
            }
        }
        System.out.println(sum);
    }

    public static int getCardValue(String card){

        int value = 0;
        switch (card.split("[SHDC]")[0]){
            case "2": value = 20;
            break;
            case "3": value = 30;
            break;
            case "4": value = 40;
            break;
            case "5": value = 50;
            break;
            case "6": value = 60;
            break;
            case "7": value = 70;
            break;
            case "8": value = 80;
            break;
            case "9": value = 90;
            break;
            case "10": value = 100;
            break;
            case "J": value = 120;
            break;
            case "Q": value = 130;
            break;
            case "K": value = 140;
            break;
            case "A": value = 150;
            break;
        }
        return value;
    }
}
