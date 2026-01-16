//This code is made by Emmitt Murray. It takes inputs and then responds to those inputs.
import java.util.Scanner;
import java.util.InputMismatchException;

public class Inputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        int age = 0;
        float height = 0f;
        try {
            // Read first and last name
            System.out.print("Please enter your first name: ");
            firstName = scanner.next();

            System.out.print("Please enter your last name: ");
            lastName = scanner.next();

            System.out.println("Hello Mr/Mrs " + lastName + " or do you go by " + firstName + "?");

            // Age
            System.out.print("Please enter your age: ");
            age = scanner.nextInt();
            System.out.println("Age = " + age);

            // Height
            System.out.print("Please enter your height in meters: ");
            height = scanner.nextFloat();
            System.out.println("Height = " + height + " meters");
        //Catch errors
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
        } finally {
            scanner.close();
        }
        //Final outputs
        System.out.println("All information:" + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + age + "\nHeight: " + height + " meters");
        System.out.println("Sending data to China...");
        System.out.println("Data sent successfully! Have a nice day!");

    }
}
