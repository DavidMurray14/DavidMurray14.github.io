//This code is made by Emmitt Murray. It takes inputs and then responds based on those inputs.
import java.util.Scanner;
public class Inputs {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Please enter your name:");
String name = scanner.nextLine();
System.out.println("Hello " + name);
System.out.println("Please enter your age:");
int age = scanner.nextInt();
System.out.println("Age = " + age);
System.out.println("please enter your height in meters (e.g., 1.75):");
float height = scanner.nextFloat();
System.out.println("Height = " + height + " meters");
    }
}
