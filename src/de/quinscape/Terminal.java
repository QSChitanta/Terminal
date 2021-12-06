package de.quinscape;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Terminal {
    private String fileNameGenerator() {
        UUID code = UUID.randomUUID();
        return code.toString().substring(0,8);
    }

    private FileWriter createNewFile() throws IOException{
        return new FileWriter(fileNameGenerator() + ".txt");
    }

    private void writeText() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean isOver = true;
            FileWriter writer = createNewFile();
            while (isOver) {
                String userInput = scanner.nextLine();
                if (!userInput.isEmpty()) {
                    writer.append(userInput).append("\n");
                } else {
                    isOver = false;
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printInstructions() {
            System.out.println("Write your text below: ");
    }

    public void startApplication() {
        printInstructions();
        writeText();
    }
}