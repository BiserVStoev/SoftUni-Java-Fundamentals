package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that reads a text file and changes the casing of all letters to upper. The file should be overwritten.
 * Use BufferedReader, FileReader, FileWriter, and PrintWriter.
 */

public class _02_AllCapitals {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        try(
                BufferedReader br =
                        new BufferedReader(
                        new FileReader("res/lines2.txt"))
        ){

            String str;

            while((str = br.readLine()) != null){
                text.add(str.toUpperCase());
            }

            br.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(PrintWriter pw =
                            new PrintWriter(
                            new FileWriter("res/lines2.txt", false))
        ){
            for (int i = 0; i < text.size(); i++) {
                pw.write(text.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
