//This code is made by Emmitt Murray. It is intended to read data from info.txt and print it.
//Afterwards it will calculate how many hamburgers all can buy together.

//The codes package. Not sure if needed after some changes.
package BigCodeA;

//Importing
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Code Start
public class reader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\jdmur\\OneDrive\\Documents\\javaCode\\BigCodeA\\info.txt"; // Sorry, my computer can't find the file if I use a relative path.
        BufferedReader br = null;
        int totalMoney = 0; // accumulator for all people's money
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder block = new StringBuilder();
            while ((line = br.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.equals("_")) {
                    Integer m = processPersonBlock(block.toString());
                    if (m != null) totalMoney += m;
                    block.setLength(0);
                } else {
                    block.append(line).append("\n");
                }
            }
            if (block.length() > 0) {
                Integer m = processPersonBlock(block.toString());
                if (m != null) totalMoney += m;
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("I/O error reading file: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    
                }
            }
        }
        // After reading all person blocks print total and assuming a hamburger is $3 print how much they can buy.
        System.out.println("-------------------------");
        System.out.println("Total money (all people): " + totalMoney);
        double hamburgers = totalMoney / 3.0;
        System.out.println("Hamburgers they can buy together: " + hamburgers);
    
    }



    //Proccesing the people blocks.
    private static Integer processPersonBlock(String block) {
        if (block == null) return null;
        String[] lines = block.split("\\r?\\n");
        String name = "";
        Integer moneyInt = null;
        System.out.println("--- Person ---");
        for (String l : lines) {
            String t = l.trim();
            if (t.isEmpty() || t.startsWith("//")) continue;
            System.out.println(t);
            String lower = t.toLowerCase();
            if (lower.startsWith("name:")) {
                name = t.substring(t.indexOf(":") + 1).trim();
            } else if (lower.startsWith("money:")) {
                String val = t.substring(t.indexOf(":" ) + 1).trim();
                String digits = val.replaceAll("[^0-9-]", "");
                if (!digits.isEmpty()) {
                    try {
                        moneyInt = Integer.parseInt(digits);
                    } catch (NumberFormatException e) {
                        moneyInt = null;
                    }
                }
            }
        }
        if (!name.isEmpty()) {
            System.out.println("Name: " + name);
        }
        if (moneyInt != null) {
            System.out.println("Money: " + moneyInt);
        } else {
            System.out.println("Money: could not parse");
        }
        return moneyInt;
    }
}