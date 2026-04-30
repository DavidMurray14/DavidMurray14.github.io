package CardGameCode;
public class DeckTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Deck size: " + deck.size());
        deck.shuffle();
        System.out.println("Top card drawn: " + deck.draw());
        System.out.println("Deck size after draw: " + deck.size());
    }
}
