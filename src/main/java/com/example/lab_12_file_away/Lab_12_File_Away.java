package com.example.lab_12_file_away;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Lab_12_File_Away {
        public static void main(String[] args) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName();
                int lines = 0;
                int words = 0;
                int characters = 0;

                try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines++;
                        characters += line.length();
                        words += countWords(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("File Summary Report:");
                System.out.println("File Name: " + fileName);
                System.out.println("Number of Lines: " + lines);
                System.out.println("Number of Words: " + words);
                System.out.println("Number of Characters: " + characters);
            }
        }

        private static int countWords(String line) {
            String[] wordsArray = line.split("\\s+");
            return wordsArray.length;
        }
    }
