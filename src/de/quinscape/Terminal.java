package de.quinscape;

import java.io.*;

import java.util.Scanner;
import java.util.UUID;

public class Terminal {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean isOver = true;

    private boolean doesFileExist(String fileName){
        fileName = mainFile();
        return fileName.isBlank();
    }

    public String mainFile(){
        File mainFile = new File("/Users/pchitanta/Documents/JavaCourseUdemy/Terminal/49e7b828-c9a2-46e4-93f5-" +
                "cbecf45a013c.txt");
        return mainFile.toString();
    }

    private String fileNameGenerator() {
        UUID code = UUID.randomUUID();
        return code.toString();
    }

    private void writeText() {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(fileNameGenerator() + ".txt");
            while (isOver) {
                String userInput = scanner.nextLine();
                if (!userInput.isEmpty()) {
                    writer.append(userInput).append("\n");
                } else {
                    isOver = false;
                    writer.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void appendText() throws IOException {
        try (java.io.FileWriter wr = new java.io.FileWriter("49e7b828-c9a2-46e4-93f5-cbecf45a013c.txt", true)) {
            wr.append("\n").append(scanner.nextLine());
        }
    }

    private void printIfFileExists() {
        if (doesFileExist(mainFile())) {
            System.out.println("Main File already exists.");
        } else {
            System.out.println("Main file does not exist. Creating main...");
        }
    }

    private void printAppendMessage() {
        System.out.println("Append text to existing file: ");
    }

    private void printWriteMessage() {
        System.out.println("Write your text below: ");
    }

    public void startApplication() throws IOException {
        if (doesFileExist(mainFile())) {
            printIfFileExists();
            printAppendMessage();
            appendText();
        } else {
            printIfFileExists();
            printWriteMessage();
            writeText();
        }
    }
}
//TODO ich will das mein UUID nur 8 Zeichen erstellt
