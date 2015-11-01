package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _03_TheHeiganDance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int playerHP = 18_500;
        double heiganHP = 3_000_000d;

        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        String[][] chamber = new String[15][15];

        fillMatrix(chamber);
        chamber[15/2][15/2] = "P";

        int playerRow = 15 / 2;
        int playerCol = 15 / 2;

        int damageFromPreviousTurn = 0;

        boolean heiganDead = false;
        boolean playerDead = false;

        String causeOfDeath = "";

        while (true){

            String[] turn = scanner.nextLine().split(" ");

            heiganHP -= damageToHeigan;
            if (heiganHP <= 0){
                heiganDead = true;
            }

            String spell = turn[0];
            int row = Integer.parseInt(turn[1]);
            int col = Integer.parseInt(turn[2]);

            playerHP -= damageFromPreviousTurn;
            if (playerHP <= 0){
                causeOfDeath = "Plague Cloud";
                playerDead = true;
            }
            damageFromPreviousTurn = 0;

            if (heiganDead || playerDead){
                break;
            }

            if (spell.equals("Cloud")){
                if (checkIfPlayerIsInsideRadius(chamber, row, col)){

                    String playerEscape = playerEscape(chamber, row, col, playerRow, playerCol, 3500);
                    int damageToDo = Integer.parseInt(playerEscape.split(" ")[2]);
                    playerRow += Integer.parseInt(playerEscape.split(" ")[0]);
                    playerCol += Integer.parseInt(playerEscape.split(" ")[1]);
                    playerHP -= damageToDo;

                    if (playerHP <= 0){
                        playerDead = true;
                        causeOfDeath = "Plague Cloud";
                    }

                    damageFromPreviousTurn = damageToDo;
                }
            }else if (spell.equals("Eruption")){

                if (checkIfPlayerIsInsideRadius(chamber, row, col)){
                    String playerEscape = playerEscape(chamber, row, col, playerRow, playerCol, 6000);
                    int damageToDo = Integer.parseInt(playerEscape.split(" ")[2]);
                    playerRow += Integer.parseInt(playerEscape.split(" ")[0]);
                    playerCol += Integer.parseInt(playerEscape.split(" ")[1]);


                    playerHP -= damageToDo;
                    if (playerHP <= 0){
                        playerDead = true;
                        causeOfDeath = "Eruption";
                    }
                }


            }

            if (playerDead){
                break;
            }

        }
        if (heiganDead){
            System.out.println("Heigan: Defeated!");
        }else{
            System.out.printf("Heigan: %.2f\n", heiganHP);
        }
        if (playerDead){
            System.out.printf("Player: Killed by %s\n", causeOfDeath);
        }else{
            System.out.println("Player: " + playerHP);
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);

    }

    public static boolean checkIfPlayerIsInsideRadius(String[][] chamber, int row, int col){
        boolean isInside = false;

        if (checkIfInsideChamber(chamber, row, col)){
            if (chamber[row][col].equals("P")) {
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row - 1, col)){
            if (chamber[row - 1][col].equals("P")){
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row - 1, col + 1)){
            if (chamber[row - 1][col + 1].equals("P")){
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row - 1, col - 1)){
            if (chamber[row - 1][col - 1].equals("P")){
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row, col - 1)){
            if (chamber[row][col - 1].equals("P")){
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row, col + 1)){
            if (chamber[row][col + 1].equals("P")){
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row + 1, col - 1)){
            if (chamber[row + 1][col - 1].equals("P")){
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row + 1, col)){
            if (chamber[row + 1][col].equals("P")){
                isInside = true;
            }
        }

        if (checkIfInsideChamber(chamber, row + 1, col + 1)){
            if (chamber[row + 1][col + 1].equals("P")){
                isInside = true;
            }
        }

        return  isInside;
    }

    public static boolean checkIfInsideChamber(String[][] chamber, int row, int col){
        boolean isInsideChamber = false;

        if (row >= 0 && row < chamber.length && col >=0 && col < chamber[row].length){
            isInsideChamber = true;
        }

        return isInsideChamber;
    }

    public static String playerEscape(String[][] chamber, int row, int col, int playerRow, int playerCol, int damageToDo){

        List<String> damagedCells = Arrays.asList(row + " " + col, (row - 1) + " " + col, (row - 1) + " " + (col - 1), (row - 1) + " " + (col + 1),
                row + " " + (col - 1), row + " " + (col + 1), (row + 1) + " " + col, (row + 1) + " " + (col - 1), (row + 1) + " " + (col + 1));

        if (checkIfInsideChamber(chamber, playerRow - 1, playerCol) && !damagedCells.contains((playerRow - 1) + " " + playerCol)){
            chamber[playerRow][playerCol] = "e";
            chamber[playerRow - 1][playerCol] = "P";
            return String.format("%d %d %d", -1, 0, 0);
        }else if (checkIfInsideChamber(chamber, playerRow, playerCol + 1) && !damagedCells.contains((playerRow) + " " + (playerCol + 1))){
            chamber[playerRow][playerCol] = "e";
            chamber[playerRow][playerCol + 1] = "P";
            return String.format("%d %d %d", 0, 1, 0);
        }else if (checkIfInsideChamber(chamber, playerRow + 1, playerCol) && !damagedCells.contains((playerRow + 1) + " " + playerCol)){
            chamber[playerRow][playerCol] = "e";
            chamber[playerRow + 1][playerCol] = "P";
            return String.format("%d %d %d", 1, 0, 0);
        }else if (checkIfInsideChamber(chamber, playerRow, playerCol - 1) && !damagedCells.contains(playerRow + " " + (playerCol - 1))){
            chamber[playerRow][playerCol] = "e";
            chamber[playerRow][playerCol - 1] = "P";
            return String.format("%d %d %d", 0, -1, 0);
        }else{
            return String.format("%d %d %d", 0, 0, damageToDo);
        }

    }

    public static void fillMatrix(String[][] chamber){
        for (int i = 0; i < chamber.length; i++) {
            for (int j = 0; j < chamber[i].length; j++) {
                chamber[i][j] = "e";
            }
        }
    }
}
