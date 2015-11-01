package com.company;

import java.io.*;

/**
 * Write a program that saves and loads the information from a custom Object that you have created to a file using ObjectInputStream, ObjectOutputStream.
 * Create a class Course that has a String field containing the name and an integer field containing the number of students attending the course.
 * Set the name of the new file as course.save.
 */

public class _06_SaveACustomObjectInAFile {
    private static Course[] courses;

    public static void main(String[] args) {
        courses = new Course[3];
        courses[0] = new Course("Maths", 7);
        courses[1] = new Course("History", 12);
        courses[2] = new Course("CSharp", 24);
        saveCourse();
        loadCourse();

    }

    private static void loadCourse() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("res/course.save")))) {

            Object obj;
            while ((obj = objectInputStream.readObject()) != null) {
                System.out.println(obj);
            }
        } catch (EOFException eof) {
            System.out.println("END OF FILE!");
        } catch (ClassNotFoundException | IOException cnne) {
            System.out.println(cnne.toString());
        }
    }

    private static void saveCourse() {
        try (
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("res/course.save")))
        ) {
            for (Course p : courses) {
                objectOutputStream.writeObject(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}