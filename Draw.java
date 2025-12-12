package CardGameCode; //CardGameCode made by Emmitt Murray.
// Code for drawing cards and comparing hands.
import java.util.ArrayList;
import java.util.List;

public class Draw {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        int playersCount = 5;
        int cardsPerHand = 5;
        List<List<Card>> playerHands = new ArrayList<>();
        for (int p = 0; p < playersCount; p++) {
            playerHands.add(new ArrayList<>());
        }

        // Deal to each player 
        for (int p = 0; p < playersCount; p++) {
            System.out.println("Player " + (p + 1) + " hand:");
            for (int i = 0; i < cardsPerHand; i++) {
                Card drawnCard = deck.draw();
                if (drawnCard == null) {
                    System.out.println("No more cards in deck.");
                    break;
                }
                playerHands.get(p).add(drawnCard);
                System.out.println(drawnCard);
            }
            System.out.println("Cards remaining in deck: " + deck.size());
            System.out.println();
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