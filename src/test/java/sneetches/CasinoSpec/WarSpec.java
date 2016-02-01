package sneetches.CasinoSpec;

import org.junit.*;
import static org.junit.Assert.*;
import sneetches.Casino.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by willhorton on 1/29/16.
 */
public class WarSpec {

    CardGame cardGame;
    Player player;
    ArrayList<Card> cardDeck;
    War war;
    Card card1;
    Card card2;
    @Before
    public void initialize() {
        player = new Player();
        cardGame = new CardGame(player);
        cardDeck = cardGame.getDeck().getDeckList();
        war = new War(player);
        card1 = new Card(Suit.CLUBS, Value.ACE);
        card2 = new Card(Suit.DIAMONDS, Value.JACK);
    }


    @Test
    public void dealDeckTest() {
        Player human = war.getPlayer(0);
        Player compu = war.getPlayer(1);
        ArrayList<Card> humanHand = human.getHand();
        ArrayList<Card> compuHand = compu.getHand();
        war.dealDeck();
        System.out.println(human.getHandSize());
        assertEquals(26,compuHand.size());
    }


    @Test
    public void playFourCardsTest() {
        war.dealDeck();
        int firstSize = war.getPlayer(0).getHand().size();
        war.playWarCards(0);
        int secondSize = war.getPlayer(0).getHand().size();
        System.out.println(firstSize);
        System.out.println(secondSize);

    }

    @Test
    public void drawPlayTest(){
        war.dealDeck();
        war.drawPlay(card1, card2);
    }


    @Test
    public void winPileTest(){
        war.dealDeck();
        war.getPlayer(0).addWinCard(card1);
        int actual = war.getPlayer(0).getWinCard(0).getPoints();
        assertEquals(14, actual);
    }


    @Test
    public void playTest(){

        war.play();
    }

    @Test
    public void normPlayTest(){
        war.dealDeck();
        int winSizeBefore = war.getPlayer(0).getWinPile().size();

        war.normPlay(card1, card2);
        System.out.println(war.getPlayer(0).getWinPile().size());
        //assertEquals(winSizeBefore + 2, war.getPlayer(0).getWinPile().size());
    }


    @Test
    public void compareTest(){
        war.getPlayer(0).addWinCard(card1);
        war.getPlayer(0).addWinCard(card2);
        war.compareWinnings();
    }


}