package sneetches.CasinoSpec;

import org.junit.*;
import static org.junit.Assert.*;
import sneetches.Casino.*;

import java.util.ArrayList;

/**
 * Created by willhorton on 1/29/16.
 */
public class CardGameSpec {

    CardGame cardGame;
    Player player;
    ArrayList<Card> cardDeck;
    @Before
    public void initialize() {
        player = new Player();
        cardGame = new CardGame(player);
        cardDeck = cardGame.getDeck().getDeckList();
    }

    @Test
    public void dealHandsTest(){

        cardGame.dealHands(7, player);
        Card testCard1 = player.getHandCard(6);
        assertNotNull(testCard1);
        System.out.println(cardDeck.size());

    }

    @Test
    public void isDeckEmptyTest() {
        cardGame.dealHands(52, player);
        assertEquals(true, cardGame.isDeckEmpty());
        System.out.println(cardDeck.size());
    }

    @Test
    public void isHandEmptyTest() {
        Player computer = cardGame.getPlayer(1);
        ArrayList<Card> playerHand = computer.getHand();
        int size = playerHand.size();
        cardGame.dealHands(7, computer);
        assertEquals(false, cardGame.isHandEmpty(computer));
    }

    @Test
    public void shuffleTest(){
        assertNotNull(cardGame.getDeck().getCard(51));
        Card testCard1 = cardGame.getDeck().getCard(51);
        cardGame.shuffle();
        Card testCard2 = cardGame.getDeck().getCard(51);
        assertTrue(!(testCard1 == testCard2));
        ArrayList<Card> cardDeck1 = cardGame.getDeck().getDeckList();
        int deck1Size = cardDeck1.size();
        //int deckSize = cardGame.getDeck().getDeckList().size();

        System.out.println(deck1Size);
        for (int i = 0; i < deck1Size; i++){

            Suit suit = cardDeck1.get(i).getSuit();
            Value value = cardDeck1.get(i).getValue();

            System.out.println("" + suit + value);
        }



    }

}
