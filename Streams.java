//This code is made by Emmitt Murray. It uses data streams to make a file with my information.
//Importing classes.
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//Code start.
public class Streams {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); //Scanner object created.
        //User inputs name, school, grade, and GPA.
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your school: ");
        String school = scanner.nextLine();
        System.out.print("Enter your grade: ");
        int grade = scanner.nextInt();
        System.out.print("Enter your GPA: ");
        scanner.nextLine(); 
        String GPA = scanner.nextLine();
        //Printing the information to a file.
        try (PrintWriter writer = new PrintWriter(new FileWriter("Student.txt"))) {
            writer.println("Name: " + name);
            writer.println("School: " + school);
            writer.println("Grade: " + grade);
            writer.println("GPA: " + GPA);
            System.out.println("Information saved to Student.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        scanner.close(); //Closing the scanner.
    }
}