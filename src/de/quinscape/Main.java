package de.quinscape;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Terminal terminal = new Terminal();
        System.out.println("(IMPORTANT: If you have a text file already and want to append text, " +
                "add it to your IDE's main configuration)");
        if (args.length == 0) {
            terminal.appendToFile();
        }
        if (args.length != 0){
            terminal.appendToGivenFile(args[0]);
        }
    }
}