package sneetches.CasinoSpec;

import org.junit.Before;
import org.junit.Test;
import sneetches.Casino.*;
import static org.junit.Assert.*;

/**
 * Created by yanimartin on 1/30/16.
 */
public class DeckSpec {

    Deck deck;
    Card card;
    Card randomCard;
    Card nullRandomCard;

    @Before
    public void initialize(){
        deck = new Deck();
    }

    @Test
    public void deckTest(){
        int length = deck.getDeckList().size();
        assertEquals(52, length);
    }

    @Test
    public void testGetCard() {
        card = deck.getCard(0);
        assertTrue(card instanceof Card);
    }

    @Test
    // Tests that getRandomCard() returns 52 cards in a row and then returns null when deck is empty
    public void testGetRandomCard() {
        for(int i = 0; i < 52; i++) {
            randomCard = deck.getRandomCard();
            assertTrue(randomCard instanceof Card);
        }
        nullRandomCard = deck.getRandomCard();
        assertNull(nullRandomCard);

    }

    @Test
    public void shuffleTest(){

    }



}
