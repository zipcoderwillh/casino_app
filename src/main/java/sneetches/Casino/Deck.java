package sneetches.Casino;

import java.util.ArrayList;
import java.util.Random;

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

    public Card getRandomCard() {
        // Checks to see if deck is empty (deck.size() > 0), and if so removes and returns a random card within
        // the range of remaining cards (rand.nextInt(deck.size())). If deck is already empty, returns null.
        Random rand = new Random();
        return deck.size() > 0 ? deck.remove(rand.nextInt(deck.size())) : null;
    }

}
