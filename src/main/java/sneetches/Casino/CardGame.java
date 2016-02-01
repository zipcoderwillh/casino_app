package sneetches.Casino;

import java.util.ArrayList;

/**
 * Created by willhorton on 1/29/16.
 */

public class CardGame extends Game{

    protected Deck deck = new Deck();

    public CardGame(Player player){
        ArrayList<Player> players = getPlayers();
        players.add(player);
        Player computer = new Player();
        players.add(computer);

    }

    public void dealHands(int number, Player player) {
        //ArrayList<Card> deck = getDeck().getDeckList();
        shuffle();
        for(int i = 0; i < number; i++) {
            int size = deck.getDeckList().size();
            Card tempCard = getDeck().getCard(size - 1);
            player.addHandCard(tempCard);

            deck.getDeckList().remove(size - 1);
        }

    }

    public boolean isDeckEmpty(){

        if (deck.getDeckList().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isHandEmpty(Player player){
        int size = player.getHand().size();
        if (size < 1){
            return true;
        }else {
            return false;

        }


    }

    public Deck getDeck(){
        return deck;

    }


    public void shuffle() {
        ArrayList<Card> temp = new ArrayList<Card>();
        ArrayList<Card> deck = getDeck().getDeckList();
        while (!deck.isEmpty()){
            int randNum = (int) (Math.random() * deck.size());
            temp.add(deck.get(randNum));
            deck.remove(randNum);
        }
        getDeck().setDeck(temp);
    }



}
