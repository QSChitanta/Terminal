package de.quinscape;

public class Main {
    public static void main(String[] args) {
        //args[0] == null, oh i found something haha
        Terminal terminal = new Terminal();
        terminal.startApplication();
    }
}

//        if(args.length != 0){
//            terminal.startApplication();
//        } else {
//            terminal.startApplicationWithExistingFile(args[0]);
//        }
//        terminal.startApplicationWithExistingFile("existingFile.txt");
//    }

//anwendung soll schauen ob es eine datei gibt, über args main

//wenn ich das programm starte, soll ein parameter erstellen , das soll die chooseFile methode ersetzen