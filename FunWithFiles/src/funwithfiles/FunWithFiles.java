/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithfiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author Stegger
 */
public class FunWithFiles
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        System.out.println("1");
        FunWithFiles.readExampleOne();
//        System.out.println("2");
//        FunWithFiles.readExampleTwo();
//        System.out.println("3");
//        FunWithFiles.readExampleThree();
//        FunWithFiles.writeExampleOne();
        System.out.println("Done!");
    }

    public static void readExampleOne() throws FileNotFoundException
    {
        File f = new File("brit-a-z.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNext())
        {
            String line = sc.nextLine();
            System.out.println(line);
        }

    }

    public static void readExampleTwo() throws FileNotFoundException
    {
        File f = new File("C:\\Users\\pgn\\Documents\\NetBeansProjects\\WordSearcher\\brit-a-z.txt");
        Scanner sc = new Scanner(new BufferedReader(new FileReader(f)));
        while (sc.hasNext())
        {
            String line = sc.nextLine();
            System.out.println(line);
        }
    }

    public static void readExampleThree() throws IOException
    {
        Path p = new File("C:\\Users\\pgn\\Documents\\NetBeansProjects\\WordSearcher\\brit-a-z.txt").toPath();

        for (String line : Files.readAllLines(p, StandardCharsets.ISO_8859_1))
        {
            System.out.println(line);
        }
    }

    public static void writeExampleOne() throws IOException
    {
        String test = "TEST";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt")))
        {
            writer.write("Hello?");
            writer.newLine();
            writer.write("Can you hear me?");
            writer.write("No?");
            writer.newLine();
            writer.write("Then I \nAm\nOut\nOf\nHere!");
            writer.write(test);
        }
    }

}
