package com.company;

import java.util.Scanner;

public class _01_CountBeers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int beers = 0;
        int currentBeers;

        while(!input.equals("End")){

            String[] beerData = input.split(" ");

            currentBeers = Integer.parseInt(beerData[0]);

            if (beerData[1].equals("stacks")){
                currentBeers *= 20;
            }

            beers += currentBeers;

            input = scanner.nextLine();
        }

        System.out.printf("%d stacks + %d beers", beers / 20, beers % 20);
    }
}
