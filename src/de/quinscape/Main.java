package de.quinscape;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        if(args.length != 0){
            terminal.startApplication();
        } else {
            terminal.startApplicationWithExistingFile(args[0]);
        }

    }
}