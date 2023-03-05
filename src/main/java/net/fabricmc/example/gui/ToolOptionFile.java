package net.fabricmc.example.gui;

import java.io.*;
import java.util.Scanner;

public class ToolOptionFile {
    static String fileName = "toolOption.txt";
    static String path = "..\\option\\" + fileName;
    static File options;

    public static void initFile() {
        File file = new File(path);
        if (!file.exists()) {
            createFile();
            writeFile();
        }
        options = file;
    }

    public static String getFileOption() {
        String data = "";
        Scanner myReader;
        try {
            myReader = new Scanner(new FileReader(path));
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
                System.out.println(data);
            }
            myReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void createFile() {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("Files in Java might be tricky, but it is fun enough!");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
