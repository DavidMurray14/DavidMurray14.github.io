// CardGameCode made by Emmitt Murray.
// Code for individual cards.
package CardGameCode;
public class Card {
    public final String suit;
    public final String rank;
    public final int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    @Override
    public String toString() { //Cards display format.
        return rank + " of " + suit + " (" + value + ")";
    }
}
