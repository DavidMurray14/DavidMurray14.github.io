//This code is made by Emmitt Murray. It reads letter_frequency and prints ou the data.
//Importing.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Start code.
public class Frequency {
    public static void main(String[] args) {
        //Locating the file. (This part tried to break the whole code)
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jdmur\\OneDrive\\Documents\\javaCode\\JavaCodes+\\letter_frequency.csv"))) {
            String line;
            System.out.println("Reading information from letter_frequency.csv:");
            long sumFreq = 0L;
            float sumPct = 0f;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                // Skip header
                if (line.toLowerCase().contains("letter") && line.toLowerCase().contains("frequency")) continue;
                // Use StringTokenizer
                java.util.StringTokenizer st = new java.util.StringTokenizer(line, ",");
                if (st.countTokens() < 3) continue;
                String letter = st.nextToken().replaceAll("\"", "").trim();
                String freqStr = st.nextToken().replaceAll("\"", "").trim();
                String pctStr = st.nextToken().replaceAll("\"", "").trim();
                try {
                    int frequency = Integer.parseInt(freqStr);
                    float percentage = Float.parseFloat(pctStr);
                    System.out.println("Letter: " + letter + ", Frequency: " + frequency + ", Percentage: " + percentage);
                    sumFreq += (long) frequency;
                    sumPct += percentage;
                    count++;
                } catch (NumberFormatException nfe) { //Skip line if frequency or percentage is not a number.
                    System.out.println("Skipping line: " + line);
                }
            }
            //Calculate and print averages
            if (count > 0) {
                double avgFreq = (double) sumFreq / count;
                float avgPct = sumPct / count;
                System.out.println();
                System.out.println("Count: " + count);
                System.out.println("Average Frequency: " + avgFreq);
                System.out.println("Average Percentage: " + avgPct);
            } else {
                System.out.println("No numeric data found to average.");
            }
            //Catch errors while reading the file.
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
