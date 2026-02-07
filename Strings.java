//This code is made by Emmitt Murray. It manipultates strings in Java.
import java.util.Scanner;
import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        String original = "  The quick brown fox jumps over the lazy dog.  ";
        //Original string
        System.out.println("Original String: '" + original + "'");

        
        String trimmed = original.trim();

        
        String cleaned = trimmed.replaceAll("[^a-zA-Z\\s]", "");
        String[] words = cleaned.split("\\s+");

        // Printing the first array
        System.out.println("Words array: " + Arrays.toString(words));
        System.out.println("Number of words: " + words.length);
        
        //User input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String userInput = scanner.nextLine(); 

        String Trimmed = userInput.trim();

        String Cleaned = Trimmed.replaceAll("[^a-zA-Z\\s]", "");
        String[] Words = Cleaned.split("\\s+");
        // Printing the second array
        System.out.println("Words array: " + Arrays.toString(Words));
        System.out.println("Number of words: " + Words.length);
        //close scanner
        scanner.close();
    }

}

