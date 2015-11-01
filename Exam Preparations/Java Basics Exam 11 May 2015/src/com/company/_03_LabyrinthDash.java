package com.company;

import java.util.Scanner;

public class _03_LabyrinthDash {

    public static void main(String[] args) {

        final String ObstacleCharacters = "*#@";

        Scanner scanner = new Scanner(System.in);

        int numberOfRows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[numberOfRows][];

        for (int i = 0; i < numberOfRows; i++) {
            String inputLine = scanner.nextLine();

            matrix[i] = inputLine.toCharArray();
        }

        String commands = scanner.nextLine();

        int livesLeft = 3;
        int row = 0;
        int col = 0;
        int movesMade = 0;

        for (char direction : commands.toCharArray()) {
            int previousRow = row;
            int previousCol = col;

            switch (direction)
            {
                case '<':
                    col--;
                    break;
                case '>':
                    col++;
                    break;
                case 'v':
                    row++;
                    break;
                case '^':
                    row--;
                    break;
            }

            if (!IsCellIsideMatrix(row, col, matrix) || matrix[row][col] == ' ') {
                System.out.println("Fell off a cliff! Game Over!");
                movesMade++;
                break;
            }

            if (matrix[row][col] == '_' || matrix[row][col] == '|') {
                System.out.println("Bumped a wall.");
                row = previousRow;
                col = previousCol;;
            } else if (ObstacleCharacters.contains(matrix[row][col] + "")) {
                livesLeft--;
                movesMade++;
                System.out.printf("Ouch! That hurt! Lives left: %d\n", livesLeft);

                if (livesLeft <= 0) {
                    System.out.println("No lives left! Game Over!");
                    break;
                }
            } else if (matrix[row][col] == '$') {
                livesLeft++;
                movesMade++;
                matrix[row][col] = '.';
                System.out.printf("Awesome! Lives left: %d\n", livesLeft);
            } else {
                movesMade++;
                System.out.println("Made a move!");
            }
        }

        System.out.printf("Total moves made: %d", movesMade);
    }

    private static boolean IsCellIsideMatrix(int row, int col, char[][] matrix) {
        boolean isRowInsideMatrix = 0 <= row && row < matrix.length;

        if (!isRowInsideMatrix) {
            return false;
        }

        boolean isColInRange = 0 <= col && col < matrix[row].length;

        return isColInRange;
    }
}