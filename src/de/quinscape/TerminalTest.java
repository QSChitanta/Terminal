package de.quinscape;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TerminalTest {

//    @org.junit.jupiter.api.Test
//    void writeMessage() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void appendText() throws IOException {
//        FileWriter fr = new FileWriter("/Users/pchitanta/Documents/JavaCourseUdemy/Terminal/49e7b828-c9a2-46e4-93f5-cbecf45a013c.txt");
//        assertEquals(fr, new FileWriter("/Users/pchitanta/Documents/JavaCourseUdemy/Terminal/49e7b828-c9a2-46e4-93f5-cbecf45a013c.txt"));
//    }

    @Test
    void checkMainFileExistence() {
        File mainFile = new File("/Users/pchitanta/Documents/JavaCourseUdemy/Terminal/49e7b828-c9a2-46e4-93f5-cbecf45a013c.txt");
        Assert.assertEquals(mainFile, "/Users/pchitanta/Documents/JavaCourseUdemy/Terminal/49e7b828-c9a2-46e4-93f5-cbecf45a013c.txt");
    }
}