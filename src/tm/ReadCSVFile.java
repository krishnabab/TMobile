package tm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSVFile {
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("Reading a CSV file");
        Scanner sc = new Scanner(new File("/Users/krishna/MyMacStuff/MyWorkSpace/TMobile/resources/StudentData.csv"));
        sc.useDelimiter("\t");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }
}