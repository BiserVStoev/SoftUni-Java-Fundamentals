package com.company;

import java.io.*;

/**
 * Write a program that reads a text file and prints on the console the sum of the ASCII symbols of each of its lines.
 * Use BufferedReader in combination with FileReader.
 */

public class _01_SumLines {

    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(
                new FileReader("res/lines.txt"));
        ){
            while (true){
                String line = br.readLine();
                if (line == null){
                    break;
                }

                int lineSum = 0;
                for (int i = 0; i < line.length(); i++) {
                    lineSum += (int)(line.charAt(i));
                }
                System.out.println(lineSum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
