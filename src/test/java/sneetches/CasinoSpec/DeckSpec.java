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

    @Before
    public void initialize(){
        deck = new Deck();
        card = deck.getCard(0);
        randomCard = deck.getRandomCard();
    }

    @Test
    public void testGetCard() {
        assertTrue(card instanceof Card);
    }

    @Test
    public void testGetRandomCard() {
        assertTrue(randomCard instanceof Card);
    }

    @Test
    public void deckTest(){
        int length = deck.getDeckList().size();
        assertEquals(52, length);
    }

}
