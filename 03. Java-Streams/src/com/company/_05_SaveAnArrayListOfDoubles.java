package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Write a program that saves and loads the information from an ArrayList to a file using ObjectInputStream, ObjectOutputStream.
 * Set the name of the new file as doubles.list
 */

public class _05_SaveAnArrayListOfDoubles {
    public static void main(String[] args) {

        //COMMENT OR UNCOMMENT saveArrayList();/loadArrayList(); in order to use them.

        //saveArrayList();
        loadArrayList();

    }

    private static void loadArrayList() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("res/doubles.list")))) {
            System.out.println("Doubles: "  + objectInputStream.readObject());
        }
        catch (ClassNotFoundException | IOException cnne) {
            System.out.println(cnne.toString());
        }
    }

    private static void saveArrayList() {
        try (
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("res/doubles.list")))
        ){
            List<Double> doubles = Arrays.asList(new Double[]{2.5, 13.8, 19.0, 15.3, 591.2, -13.7, 0.0});
            objectOutputStream.writeObject(doubles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
