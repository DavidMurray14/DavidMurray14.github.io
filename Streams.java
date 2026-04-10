//This code is made by Emmitt Murray. It uses data streams to make a file with my information.
//Debug statements added later for an assignment.
//Importing classes.
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//Code start.
public class Streams {
    static boolean debug = true; //Debug variable created.
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); //Scanner object created.
        //User inputs name, school, grade, and GPA.
        System.out.println("Enable debug? 1 = Yes, 2 = No"); //Enable debug statement.
        int debugChoice = scanner.nextInt();
        if (debugChoice == 1) {
            debug = true;
        } else {
            debug = false;
        }
        
        //Code Starts

        if (debug == true) {
            System.out.println("(Code started successfully)"); //Debug statement added.
        }
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        if (debug == true) {
            System.out.println("(Name input received)"); //Debug statement added.
        }
        System.out.println("Enter your school: ");
        String school = scanner.nextLine();
        if (debug == true) {
            System.out.println("(School input received)"); //Debug statement added.
        }
        System.out.print("Enter your grade (use numbers): ");
        int grade = scanner.nextInt();
        if (debug == true) {
            System.out.println("(Grade input received)"); //Debug statement added.
        }
        System.out.print("Enter your social security number: ");
        scanner.nextLine(); 
        String socialSecurityNumber = scanner.nextLine();
        if (debug == true) {
            System.out.println("(Social security number input received)"); //Debug statement added.
        }
        //Printing the information to a file.
        try (PrintWriter writer = new PrintWriter(new FileWriter("Student.txt"))) {
            writer.println("Name: " + name);
            writer.println("School: " + school);
            writer.println("Grade: " + grade);
            writer.println("Social Security Number: " + socialSecurityNumber);
            if (debug == true) {
                System.out.println("(Information saved to file)"); //Debug statement added.
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        scanner.close(); //Closing the scanner.
    
    }
}