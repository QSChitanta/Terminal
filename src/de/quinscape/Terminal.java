package de.quinscape;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.UUID;

public class Terminal {

    private FileWriter fileWriter;

    public void appendToFile() throws IOException {
        printInstructions();
        createNewFile();
        writeText();
    }

    public void appendToExisting(String filename) throws IOException {
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
                    fileWriter.append(userInput).append("\n");
                } else {
                    isOver = false;
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printInstructions() {
        System.out.println("(IMPORTANT: If you have a text file already and want to append text, " +
                "add it to your IDE's main configuration)");
        System.out.println("Write your text below and press return on an empty line to exit");
    }

    public void startWithFileOrCreateNew(String filename) throws IOException {
        if (Files.exists(Path.of(filename))) {
            try {
                fileWriter = new FileWriter(filename, true);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            createNewFile();
        }
    }

    private void createNewFile() throws IOException {
        fileWriter = new FileWriter(fileNameGenerator() + ".txt");
    }

    private String fileNameGenerator() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}