package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _03_FireTheArrows {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[lines][];

        for (int i = 0; i < matrix.length; i++) {

            matrix[i] =  scanner.nextLine().toCharArray();
        }

        boolean moved = true;
        List<Character> arrows = Arrays.asList('^', 'v', '<', '>');

        while (moved){
            moved = false;

            boolean hasMoved = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    char currentChar = matrix[i][j];


                    if (arrows.contains(currentChar)){

                        moved = arrowMove(matrix, i, j, currentChar, arrows);

                        if (moved){
                            hasMoved = true;
                        }
                    }
                }
            }

            if (hasMoved){
                moved = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }

    }

    public static boolean arrowMove(char[][] matrix, int row, int col, char move, List<Character> arrows){

        boolean moved = false;
        switch (move){
            case '>':
                if (col + 1 < matrix[row].length && !arrows.contains(matrix[row][col + 1])){
                    matrix[row][col] = 'o';
                    matrix[row][col + 1] = '>';
                    moved = true;

                }
                break;
            case '<':
                if (col - 1 >= 0 && !arrows.contains(matrix[row][col - 1])){
                    matrix[row][col] = 'o';
                    matrix[row][col - 1] = '<';
                    moved = true;
                }
                break;
            case '^':
                if (row - 1 >= 0 && !arrows.contains(matrix[row - 1][col])){
                    matrix[row][col] = 'o';
                    matrix[row - 1][col] = '^';
                    moved = true;
                }
                break;
            case 'v':
                if (row + 1 < matrix.length && !arrows.contains(matrix[row + 1][col])){
                    matrix[row][col] = 'o';
                    matrix[row + 1][col] = 'v';
                    moved = true;
                }
                break;
        }
        return moved;
    }

}
