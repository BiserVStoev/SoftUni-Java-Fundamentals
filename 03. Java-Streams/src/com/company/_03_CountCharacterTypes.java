package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Write a program that reads a list of words from the file words.txt and finds the count of vowels, consonants and other punctuation marks.
 * Since English is a bit tricky, assume that a, e, i, o, u are vowels and all others are consonants. Punctuation marks are (!,.?). Do not count whitespace.
 * Write the results in file count-chars.txt.
 */

public class _03_CountCharacterTypes {
    public static void main(String[] args) {
        try(
                BufferedReader br =
                        new BufferedReader(
                        new FileReader("res/words.txt"));
                BufferedWriter bw =
                        new BufferedWriter(
                        new FileWriter("res/count-chars.txt"));
        ){
            String str;
            List<Character> vowels = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'});
            List<Character> punctuations = Arrays.asList(new Character[]{'!', '.', ',', '?'});
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationsCount = 0;
            while((str = br.readLine()) != null){
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (vowels.contains(ch)){
                        vowelsCount++;
                    }else if(punctuations.contains(ch)){
                        punctuationsCount++;
                    }else if(ch != ' '){
                        consonantsCount++;
                    }
                }
            }

            bw.write("Vowels: " + vowelsCount + "\n"
                    + "Consonants: " + consonantsCount + "\n"
                    + "Punctuation: " + punctuationsCount);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
