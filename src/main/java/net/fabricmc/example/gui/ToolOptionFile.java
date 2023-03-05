package net.fabricmc.example.gui;

import net.fabricmc.example.Option;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    public static List<Option> getFileOption() {
        List<Option> data = new ArrayList<>();
        String[] array;
        Scanner myReader;
        try {
            myReader = new Scanner(new FileReader(path));
            while (myReader.hasNextLine()) {
                Option option = new Option();
                array = myReader.nextLine().split(":");
                option.name = array[0];
                option.value = Boolean.parseBoolean(array[1]);

                data.add(option);
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
            writer.write("enableAttackBlock:false\n");
            writer.write("enableAttackEntity:false");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void updateFile(List<Option> data) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(data.get(0).name + ":" + data.get(0).value + "\n");
            writer.write(data.get(1).name + ":" + data.get(1).value);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
