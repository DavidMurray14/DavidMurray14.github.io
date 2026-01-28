//This code is made by Emmitt Murray. It is intended to read data from a file.
//Importing classes.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) {
        //Reading the information from the file.
        try (BufferedReader reader = new BufferedReader(new FileReader("Student.txt"))) {
            String line;
            System.out.println("Reading information from Student.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}