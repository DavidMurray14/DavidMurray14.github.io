package CardGameCode; //CardGameCode made by Emmitt Murray.
//Code for the deck of cards.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        reset();
    }
    //The deck.
    public final void reset() { 
        cards.clear();
        String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], i + 1));
            }
        }
    }
    //Shuffle the deck.
    public void shuffle() {
        Collections.shuffle(cards);
    }
    //Draw a card from the deck.
    public Card draw() {
        if (cards.isEmpty()) return null;
        return cards.remove(cards.size() - 1);
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
