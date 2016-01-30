package sneetches.Casino;

/**
 * Created by willhorton on 1/29/16.
 */
public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public Value getValue(){
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getPoints() {
        return value.getPoints();
    }

}
