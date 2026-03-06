package CardGameCode; //CardGameCode made by Emmitt Murray.
// Code for drawing cards and comparing hands.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        int playersCount = 5;
        int cardsPerHand = 5;

        // Ask the user if they want to be the human player (player 1)
        boolean humanPlayer = false;
        System.out.print("Do you want to play (receive cards)? (y/n): ");
        while (true) {
            String ans = scanner.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("yes")) { humanPlayer = true; break; }
            if (ans.equals("n") || ans.equals("no")) { humanPlayer = false; break; }
            System.out.print("Please answer y or n: ");
        }

        List<List<Card>> playerHands = new ArrayList<>();
        for (int p = 0; p < playersCount; p++) playerHands.add(new ArrayList<>());

        // Deal to each player
        for (int p = 0; p < playersCount; p++) {
            boolean isHuman = (p == 0 && humanPlayer);
            if (isHuman) System.out.println("Your hand:");
            else System.out.println("Player " + (p + 1) + " hand:");

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

        // If human player allow redraw of selected cards
        if (humanPlayer) {
            List<Card> humanHand = playerHands.get(0);
            System.out.println("Your current hand:");
            for (int i = 0; i < humanHand.size(); i++) {
                System.out.println((i + 1) + ": " + humanHand.get(i));
            }
            System.out.print("Enter positions to discard (1-" + cardsPerHand + ") separated by spaces, or press Enter to keep: ");
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] parts = line.split("\\s+");
                // collect indices
                java.util.Set<Integer> indices = new java.util.TreeSet<>();
                for (String part : parts) {
                    try {
                        int idx = Integer.parseInt(part.trim());
                        if (idx >= 1 && idx <= cardsPerHand) indices.add(idx - 1);
                    } catch (NumberFormatException e) {
                    }
                }
                if (!indices.isEmpty()) {
                    // redraw for each chosen index
                    for (int idx : indices) {
                        Card newCard = deck.draw();
                        if (newCard == null) {
                            System.out.println("Deck is empty; cannot redraw more cards.");
                            break;
                        }
                        humanHand.set(idx, newCard);
                    }
                    System.out.println("Your new hand:");
                    for (int i = 0; i < humanHand.size(); i++) System.out.println((i + 1) + ": " + humanHand.get(i));
                    System.out.println("Cards remaining in deck: " + deck.size());
                    System.out.println();
                } else {
                    System.out.println("No valid positions entered — keeping current hand.");
                }
            }
        }

        // Compare hands by least value.
        int bestValue = Integer.MAX_VALUE;
        List<Integer> winners = new ArrayList<>();
        System.out.println("--- Hand totals ---");
        for (int p = 0; p < playersCount; p++) {
            int total = handValue(playerHands.get(p));
            System.out.println("Player " + (p + 1) + " total: " + total);
            if (total < bestValue) {
                bestValue = total;
                winners.clear();
                winners.add(p + 1);
            } else if (total == bestValue) {
                winners.add(p + 1);
            }
        }

        // Printing the winner.
        if (winners.isEmpty()) {
            System.out.println("No winner (no hands dealt)." );
        } else if (winners.size() == 1) {
            System.out.println("Winner (lowest total): Player " + winners.get(0) + " (" + bestValue + ")");
        } else {
            System.out.println("Tie between players (lowest total): " + winners + " (" + bestValue + ")");
        }
        scanner.close();
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