package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Write a program that reads three txt files words.txt, count-chars.txt and lines.txt and create a zip archive named text-files.zip.
 * Use FileOutputStream, ZipOutputStream, and FileInputStream.
 */

public class _07_CreateZipArchive {
    public static void main(String[] args) {
        String[] srcFiles = {"res/words.txt", "res/count-chars.txt", "res/lines.txt"};
        try(
                FileOutputStream fileOutputStream = new FileOutputStream("res/text-files.zip");
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream))
        ){


            byte[] buffer = new byte[4096];

            for (int i = 0; i < srcFiles.length ; i++) {
                File file = new File(srcFiles[i]);

                FileInputStream fis = new FileInputStream(file);

                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));

                int length;

                while ((length = fis.read(buffer)) > 0){
                    zipOutputStream.write(buffer, 0, length);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
