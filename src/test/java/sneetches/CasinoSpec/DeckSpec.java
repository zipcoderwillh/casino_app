package sneetches.CasinoSpec;

import org.junit.*;
import static org.junit.Assert.*;
import sneetches.Casino.*;

/**
 * Created by shaungould on 1/30/16.
 */
public class DeckSpec {
    Deck deck;
    @Before
    public void initialize(){
        deck = new Deck();

    }


    @Test
    public void deckTest(){
        int length = deck.getDeckList().size();
        assertEquals(52, length);
    }
}
