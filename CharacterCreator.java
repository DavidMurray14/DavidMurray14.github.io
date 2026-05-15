//Removed duplicate line "public class CharacterCreator { " (EDM)
    //Java Character Creator Version 0.1, Created by HunterOma in 2026.
    //Edited and reviewed by Emmitt Murray 5/15/2026. Reviews marked with (EDM)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class CharacterCreator { //This is correct, but should be the only one. (EDM)
String selection = "c";
static String fileName = null;
String validFile = null;
String questionFile = null;
String selectedQuestions = null;
static boolean exitLoop = true;
static boolean readingCompleted = false;
static String fileName1 = null;
    public static void main(String[] args) {
        try (Scanner questionAsker = new Scanner(System.in)) { //Swithed to try. (EDM)
        System.out.println("Java Character Creator 0.1, Created by HunterOma in 2026.");
        System.out.println("Would you like to select a previous character file or create a new one? (s/c)");
        String selection = questionAsker.nextLine(); //Gets user input for creating or selecting a character file.
            if ("c".equals(selection)) {
                System.out.println("Creating a new character file. Please enter the name of your character file.");
                String fileName = questionAsker.nextLine();
                File characterFile = new File(fileName + ".txt"); //Creates a new file with the selected filename by the user.
                try {
                    if (characterFile.createNewFile()) {
                        System.out.println("File created: " + characterFile.getName()); //Tries to make the new file to check if it exists or not.
                        FileWriter fileSignature = new FileWriter(characterFile);
                        fileSignature.write("CharCreaSignature\n");
                        fileSignature.close();
                        //Removed unnecesary line. (EDM)
                        String[] questions = new String[10]; //Fixed array size to fit all questions. (EDM)
                        System.out.println("What is your character's name? No need to include nicknames, this will be in the next question.");
                        String charName = questionAsker.nextLine();
                        questions[0] = charName;
                        System.out.println("What is your character's nickname if they have one?");
                        String charNickname = questionAsker.nextLine();
                        questions[1] = charNickname;
                        System.out.println("What is your character's age?");
                        String charAge = questionAsker.nextLine();
                        questions[2] = charAge;
                        System.out.println("What is your character's species?");
                        String charSpecies = questionAsker.nextLine();
                        questions[3] = charSpecies;
                        System.out.println("What is your character's occupation/role?");
                        String charOccupation = questionAsker.nextLine();
                        questions[4] = charOccupation;
                        System.out.println("What is your character's height? This can be in both metric and imperial.");
                        String charHeight = questionAsker.nextLine();
                        questions[5] = charHeight;
                        System.out.println("What is your character's physical traits? Please list them out seperated by a comma.");
                        String charPhysical = questionAsker.nextLine();
                        questions[6] = charPhysical;
                        System.out.println("What is your character's personality traits?");
                        String charPersonality = questionAsker.nextLine();
                        questions[7] = charPersonality;
                        System.out.println("What is your character's backstory?");
                        String charBackstory = questionAsker.nextLine();
                        questions[8] = charBackstory;
                        System.out.println("What does your character personally possess on their person?");
                        String charPossessions = questionAsker.nextLine();
                        questions[9] = charPossessions;
                        System.out.println("Thank you for using the Java Character Creator, the saving process is beginning.");
                        try (BufferedWriter questionWriter = new BufferedWriter(new FileWriter(fileName + ".txt", true))) {
                            for (int i = 0; i < questions.length; i++) {
                                questionWriter.write(questions[i]+"");
                                questionWriter.newLine();
                                }  
                            System.out.println("Successfully saved to file.");
                            questionWriter.close();
                        } catch (IOException e) {
                            System.out.println("Error writing file.");
                        }
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                }
            } 
            //Fixed file reading. (EDM)
            else if("s".equals(selection)) { //Selection algorithm for the user to select a character file to read from. //Else if is a bugfix for the error that caused the if statements to run no matter what the selection was.
                System.out.println("Please enter the name of the character file."); //Gets user input for the file name of the character file they wish to select.
                String fileName1 = questionAsker.nextLine();
                File selectedFile = new File(fileName1 + ".txt"); //Selects the file for testing
                try (Scanner fileReader = new Scanner(selectedFile)) {
                    System.out.println("Testing if file is valid."); //If file is found, tests if it truly exists
                    if (fileReader.hasNextLine()) {
                        String signature = fileReader.nextLine();
                        if ("CharCreaSignature".equals(signature.trim())) {
                            System.out.println("File is valid.");
                            //Print remaining lines
                            while (fileReader.hasNextLine()) {
                                String data = fileReader.nextLine();
                                System.out.println(data);
                            }
                        } else {
                            System.out.println("File is not valid. Please select a valid character file.");
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred. Please check the file name."); //Error message if file does not exist.
                }
                        System.out.println("Opening the character file editing system.");
            ArrayList<String> fileReading = new ArrayList<String>();
            try (BufferedReader bf = new BufferedReader(new FileReader(fileName1 + ".txt"));) {
                  String line = bf.readLine();
                    while (line != null) {
                    fileReading.add(line);
                    line = bf.readLine();
                    }
                String[] array = fileReading.toArray(new String[0]);
                for (String fileData : array) {
                    System.out.println(fileData);
                }
                readingCompleted = true;
            bf.close();
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
            }
                if (readingCompleted == true) {
            while (exitLoop == true) {
            System.out.println("Starting from the characters name (index 0) to the character's personality (index 9), which information do you wish to edit? Type the index number in the first line and then the information you wish to change it with.");
            String indexSelection = questionAsker.nextLine();
            int num1 = Integer.parseInt(indexSelection);
            String newInfo = questionAsker.nextLine();
                fileReading.set(num1, newInfo);
            System.out.println("Would you like to edit more information? (y/n)");
            String editSelection = questionAsker.nextLine();
                if ("n".equals(editSelection)) {
                    exitLoop = false;
                }
                    }


                }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1 + ".txt"))) {
                for (String strings : fileReading) {
                writer.write(strings);
                writer.newLine(); 
                }
                System.out.println("Edited information written to " + fileName1 + ".txt");
            } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            }
            }
            else {
                System.out.println("Invalid selection. Please select either 's' or 'c'. It is case sensitive."); 
                }
            }
        }
    } //Edits with the } symbols. (EDM)