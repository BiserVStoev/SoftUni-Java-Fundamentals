package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Write a program that copies the contents of a .jpg file to another using FileInputStream, FileOutputStream, and byte[] buffer.
 * Set the name of the new file as my-copied-picture.jpg.
 */

public class _04_CopyJPGFile {
    public static void main(String[] args) {
        try(
                FileInputStream fileInputStream = new FileInputStream("res/picture.jpg");
                FileOutputStream fileOutputStream = new FileOutputStream("res/my-copied-picture.jpg")
        ){
            byte[] buffer = new byte[4096];
            int readBytes = 0;
            while ((readBytes = fileInputStream.read(buffer)) != - 1) {

                fileOutputStream.write(buffer, 0, readBytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
