package sneetches.Casino;

import java.util.ArrayList;

/**
 * Created by willhorton on 1/29/16.
 */
public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(){
        for (Suit s :Suit.values() ) {
            for(Value v : Value.values()){
                deck.add(new Card(s,v));
            }
        }
    }

    public ArrayList<Card> getDeckList(){
        return deck;
    }

    public Card getCard(int chosenCardIndex){
        Card chosenCard = deck.get(chosenCardIndex);
        return chosenCard;
    }

    public void setDeck(ArrayList<Card> cards){
        deck = cards;
    }
}
