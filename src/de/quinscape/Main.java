package de.quinscape;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Terminal terminal = new Terminal();

        if (args.length == 0) {
            terminal.appendToFile();
        }
        if (args.length == 1){
            terminal.appendToExisting(args[0]);
        }
    }
}