package de.quinscape;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.UUID;

public class Terminal {

    private FileWriter file;

    public void appendToFile() throws IOException {
        printInstructions();
        createNewFile();
        writeText();
    }

    public void appendToGivenFile(String filename) throws IOException {
        printInstructions();
        startWithFileOrCreateNew(filename);
        writeText();
    }

    private void writeText() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean isOver = true;
            while (isOver) {
                String userInput = scanner.nextLine();
                if (!userInput.isEmpty()) {
                    file.append(userInput).append("\n");
                } else {
                    isOver = false;
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printInstructions() {
        System.out.println("Write your text below: ");
    }

    public void startWithFileOrCreateNew(String filename) throws IOException {
        if (Files.exists(Path.of(filename))) {
            try {
                file = new FileWriter(filename, true);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            createNewFile();
        }
    }

    private void createNewFile() throws IOException {
        file = new FileWriter(fileNameGenerator() + ".txt");
    }

    private String fileNameGenerator() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}