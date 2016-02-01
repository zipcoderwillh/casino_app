package sneetches.CasinoSpec;

import org.junit.Before;
import org.junit.Test;
import sneetches.Casino.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by willhorton on 1/31/16.
 */
public class GoFishSpec {

    Player computerPlayer;
    GoFish testGame;

    @Before
    public void initialize() {
        computerPlayer = new Player();
        testGame = new GoFish(computerPlayer);
        computerPlayer.addHandCard(new Card(Suit.CLUBS, Value.EIGHT));
        computerPlayer.addHandCard(new Card(Suit.HEARTS, Value.EIGHT));
        computerPlayer.addHandCard(new Card(Suit.DIAMONDS, Value.ACE));
        computerPlayer.addHandCard(new Card(Suit.SPADES, Value.QUEEN));
    }

    @Test
    // Test that method finds all cards of specified value in other player's hand, removes them from player's hand,
    // returns them as an ArrayList<Card>, and returns null if no cards found.
    public void testAskOtherPlayer() {
        assertEquals(4, computerPlayer.getHand().size());
        ArrayList<Card> foundCards = testGame.askOtherPlayer("EIGHT", computerPlayer);
        for(Card card : foundCards) {
            assertTrue(card.getValue().toString().equals("EIGHT"));
        }
        assertEquals(2, computerPlayer.getHand().size());
        assertNull(testGame.askOtherPlayer("EIGHT", computerPlayer));
    }

    @Test
    // Test that method sorts hand in ascending order of card value
    public void testSortHand() {
        computerPlayer.addHandCard(new Card(Suit.CLUBS, Value.TWO));
        computerPlayer.addHandCard(new Card(Suit.HEARTS, Value.EIGHT));
        computerPlayer.addHandCard(new Card(Suit.CLUBS, Value.EIGHT));
        computerPlayer.addHandCard(new Card(Suit.SPADES, Value.NINE));
        computerPlayer.addHandCard(new Card(Suit.CLUBS, Value.JACK));
        computerPlayer.addHandCard(new Card(Suit.HEARTS, Value.ACE));
        testGame.sortHand(computerPlayer.getHand());
        String sortTest = "";
        for(Card card : computerPlayer.getHand()) {
            sortTest += card.getValue() + " ";
        }
        assertEquals("TWO EIGHT EIGHT EIGHT EIGHT NINE JACK QUEEN ACE ACE ", sortTest);
    }

    @Test
    // Test that method will remove and return any set of four of a kind in a hand
    public void testCheckFourOfAKind() {
        computerPlayer.addHandCard(new Card(Suit.SPADES, Value.TWO));
        computerPlayer.addHandCard(new Card(Suit.HEARTS, Value.TWO));
        computerPlayer.addHandCard(new Card(Suit.DIAMONDS, Value.EIGHT));
        computerPlayer.addHandCard(new Card(Suit.SPADES, Value.EIGHT));
        computerPlayer.addHandCard(new Card(Suit.SPADES, Value.NINE));
        computerPlayer.addHandCard(new Card(Suit.CLUBS, Value.JACK));
        computerPlayer.addHandCard(new Card(Suit.HEARTS, Value.ACE));
        testGame.sortHand(computerPlayer.getHand());
        assertEquals(11, computerPlayer.getHand().size());
        ArrayList<Card> fourOfAKind = testGame.checkFourOfAKind(computerPlayer.getHand());
        assertEquals(4, fourOfAKind.size());
        assertEquals(7, computerPlayer.getHand().size());
        String sortTest2 = "";
        for(Card card : computerPlayer.getHand()) {
            sortTest2 += card.getValue() + " ";
        }
        assertEquals("TWO TWO NINE JACK QUEEN ACE ACE ", sortTest2);
    }

}
