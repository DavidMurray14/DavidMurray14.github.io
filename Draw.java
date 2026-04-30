//Change log: ?/?/2025?: Initial version with basic card drawing and hand comparison.
//Change log 4/30/2026: Added save file, multiple players, and infinite rounds.

package CardGameCode; //CardGameCode made by Emmitt Murray.
// Code for drawing cards and comparing hands.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Draw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String saveFileName = "saveData.txt";
        //Check if user wants to reset saved points
        boolean resetScores = askYesNo(scanner, "Reset saved points? (y/n): ");
        if (resetScores) {
            java.io.File saveFile = new java.io.File(saveFileName);
            if (saveFile.exists() && !saveFile.delete()) {
                System.out.println("Warning: could not delete existing save file.");
            } else {
                System.out.println("Saved points reset.");
            }
        }
        //Number of players
        int playersCount = promptInt(scanner, "Total players (1-5) [2]: ", 1, 5, 2);
        int humanPlayers = promptInt(scanner, "Human players (0-" + playersCount + ") [1]: ", 0, playersCount, 1);
        int cardsPerHand = 5;

        int[] savedPoints = loadSavedPoints(saveFileName, playersCount);
        boolean continuePlaying = true;
        //Main game loop
        while (continuePlaying) {
            Deck deck = new Deck();
            deck.shuffle();

            List<List<Card>> playerHands = new ArrayList<>();
            for (int p = 0; p < playersCount; p++) playerHands.add(new ArrayList<>());

            // Deal to each player
            for (int p = 0; p < playersCount; p++) {
                boolean isHuman = (p < humanPlayers);
                if (isHuman) {
                    System.out.println("Human player " + (p + 1) + " hand:");
                } else {
                    System.out.println("AI player " + (p + 1) + " hand:");
                }

                for (int i = 0; i < cardsPerHand; i++) {
                    Card drawnCard = deck.draw();
                    if (drawnCard == null) {
                        System.out.println("No more cards in deck.");
                        break;
                    }
                    playerHands.get(p).add(drawnCard);
                    if (isHuman) System.out.println((i + 1) + ": " + drawnCard);
                    else System.out.println(drawnCard);
                }
                System.out.println("Cards remaining in deck: " + deck.size());
                System.out.println();
            }

            //Allow human players to discard and redraw
            for (int p = 0; p < humanPlayers; p++) {
                List<Card> hand = playerHands.get(p);
                System.out.println("Human player " + (p + 1) + " current hand:");
                for (int i = 0; i < hand.size(); i++) {
                    System.out.println((i + 1) + ": " + hand.get(i));
                }

                System.out.print("Enter positions to discard for human player " + (p + 1) + " (1-" + cardsPerHand + ") separated by spaces, or press Enter to keep: ");
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    java.util.Set<Integer> indices = new java.util.TreeSet<>();
                    for (String part : parts) {
                        try {
                            int idx = Integer.parseInt(part.trim());
                            if (idx >= 1 && idx <= cardsPerHand) indices.add(idx - 1);
                        } catch (NumberFormatException e) {
                            //Ignore invalid input
                        }
                    }
                    if (!indices.isEmpty()) {
                        for (int idx : indices) {
                            Card newCard = deck.draw();
                            if (newCard == null) {
                                System.out.println("Deck is empty; cannot redraw more cards.");
                                break;
                            }
                            hand.set(idx, newCard);
                        }
                        System.out.println("Human player " + (p + 1) + " new hand:");
                        for (int i = 0; i < hand.size(); i++) System.out.println((i + 1) + ": " + hand.get(i));
                        System.out.println("Cards remaining in deck: " + deck.size());
                        System.out.println();
                    } else {
                        System.out.println("No valid positions entered — keeping current hand.");
                    }
                }
            }

            int bestValue = Integer.MAX_VALUE;
            List<Integer> winners = new ArrayList<>();
            int[] roundScores = new int[playersCount];

            System.out.println("--- Hand totals ---");
            for (int p = 0; p < playersCount; p++) {
                int total = handValue(playerHands.get(p));
                roundScores[p] = total;
                System.out.println("Player " + (p + 1) + " total: " + total);
                if (p < humanPlayers) {
                    savedPoints[p] += total;
                }
                if (total < bestValue) {
                    bestValue = total;
                    winners.clear();
                    winners.add(p + 1);
                } else if (total == bestValue) {
                    winners.add(p + 1);
                }
            }

            if (winners.isEmpty()) {
                System.out.println("No winner (no hands dealt).");
            } else if (winners.size() == 1) {
                System.out.println("Winner (lowest total): Player " + winners.get(0) + " (" + bestValue + ")");
            } else {
                System.out.println("Tie between players (lowest total): " + winners + " (" + bestValue + ")");
            }

            printCurrentPoints(savedPoints);

            if (askYesNo(scanner, "Play again? (y/n): ")) {
                saveGameState(saveFileName, playerHands, roundScores, savedPoints, deck);
                System.out.println("Starting a new round...");
                continue;
            }

            if (askYesNo(scanner, "Save and exit? (y/n): ")) {
                saveGameState(saveFileName, playerHands, roundScores, savedPoints, deck);
                System.out.println("Saved and exiting.");
            } else {
                System.out.println("Exiting without saving this final round.");
            }
            break;
        }

        scanner.close();
    }
    
    private static int promptInt(Scanner scanner, String prompt, int min, int max, int defaultValue) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                return defaultValue;
            }
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // invalid input
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }
    //Prompt user for yes/no input
    private static boolean askYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String ans = scanner.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("yes")) return true;
            if (ans.equals("n") || ans.equals("no")) return false;
            System.out.println("Please answer y or n.");
        }
    }
    //Load save file
    private static int[] loadSavedPoints(String fileName, int playersCount) {
        int[] points = new int[playersCount];
        java.io.File file = new java.io.File(fileName);
        if (!file.exists()) {
            System.out.println("No save file found. Starting with zero points.");
            return points;
        }
        int loadedPlayers = 0;
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("Player ") && line.contains("points:")) {
                    String[] parts = line.split("points:");
                    if (parts.length == 2) {
                        String playerPart = parts[0].trim();
                        String scorePart = parts[1].trim();
                        int playerNumber = Integer.parseInt(playerPart.substring(7).trim());
                        int score = Integer.parseInt(scorePart);
                        if (playerNumber >= 1 && playerNumber <= playersCount) {
                            points[playerNumber - 1] = score;
                            loadedPlayers = Math.max(loadedPlayers, playerNumber);
                        }
                    }
                }
            }
            if (loadedPlayers > 0) {
                System.out.println("Loaded saved points for " + loadedPlayers + " player(s).");
                printCurrentPoints(points);
            } else {
                System.out.println("Save file found, but no saved points were loaded.");
            }
        } catch (java.io.IOException | NumberFormatException e) {
            System.out.println("Warning: could not read saved points, starting fresh.");
        }
        return points;
    }
    //Save current game state to a file
    private static void saveGameState(String fileName, List<List<Card>> playerHands, int[] roundScores, int[] savedPoints, Deck deck) {
        java.io.File saveFile = new java.io.File(fileName);
        java.io.File parent = saveFile.getAbsoluteFile().getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        //Save info
        try (java.io.FileWriter writer = new java.io.FileWriter(saveFile)) {
            writer.write("Saved points:\n");
            for (int p = 0; p < savedPoints.length; p++) {
                writer.write("Player " + (p + 1) + " points: " + savedPoints[p] + "\n");
            }
            writer.write("\nRound scores:\n");
            for (int p = 0; p < roundScores.length; p++) {
                writer.write("Player " + (p + 1) + " round score: " + roundScores[p] + "\n");
                writer.write("Hand: ");
                for (Card c : playerHands.get(p)) {
                    writer.write(c.toString() + " ");
                }
                writer.write("\n");
            }
            System.out.println("Game state saved to " + saveFile.getAbsolutePath());
        } catch (java.io.IOException e) {
            System.out.println("Error saving game state: " + e.getMessage());
        }
    }
    //Print current cumulative points for all players
    private static void printCurrentPoints(int[] points) {
        System.out.println("--- Current cumulative points ---");
        for (int p = 0; p < points.length; p++) {
            System.out.println("Player " + (p + 1) + ": " + points[p] + " points");
        }
        System.out.println();
    }

    private static int handValue(List<Card> hand) {
        if (hand == null || hand.isEmpty()) return 0;
        int sum = 0;
        for (Card c : hand) {
            sum += c.value;
        }
        return sum;
    }
}
