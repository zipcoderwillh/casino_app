package sneetches.Casino;

import java.util.ArrayList;

/**
 * Created by willhorton on 1/29/16.
 */
public class Player {


    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> winPile = new ArrayList<Card>();
    private String name;
    private int score;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }


    public Card getHandCard(Suit s,Value v){
        Card chosenCard;

        for(Card key : hand){
            if (key.getSuit() == s){
                if (key.getValue() == v){
                    chosenCard = key;
                    return chosenCard;
                }
            }

        }
        chosenCard = null;
        return chosenCard;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public ArrayList<Card> getWinPile(){
        return winPile;
    }

    public int getHandSize(){
        return hand.size();
    }

    public Card getHandCard(int chosenCardIndex){
        Card chosenCard = hand.get(chosenCardIndex);
        return chosenCard;
    }

    public void addHandCard (Card card){
        hand.add(card);

    }

    public Card getWinCard(Suit s,Value v){
        Card chosenCard;

        for(Card key : winPile){
            if (key.getSuit() == s){
                if (key.getValue() == v){
                    chosenCard = key;
                    return chosenCard;
                }
            }

        }
        chosenCard = null;
        return chosenCard;
    }

    public Card getWinCard(int cardIndex){
        Card chosenCard = winPile.get(cardIndex);
        return chosenCard;
    }

    public void addWinCard(Card card){
        winPile.add(card);

    }


}
