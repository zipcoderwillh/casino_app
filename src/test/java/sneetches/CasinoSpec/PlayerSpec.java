package sneetches.CasinoSpec;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import sneetches.Casino.*;

/**
 * Created by shaungould on 1/30/16.
 */
public class PlayerSpec {
    Player player;
    Card card;

    @Before
    public void initialize() {
        player = new Player();
        card = new Card(Suit.CLUBS, Value.ACE);
        player.addHandCard(card);
        player.addWinCard(card);

    }

    @Test
    public void getHandCardTest(){
        assertNotNull(player.getHandCard(0));
    }


    @Test
    public void addHandCardTest(){

        assertEquals(Suit.CLUBS, player.getHandCard(0).getSuit());
    }

    @Test
    public void addWinCardTest(){



        assertEquals(Suit.CLUBS, player.getWinCard(0).getSuit());
    }

    @Test
    public void getWinCardTest(){
        assertEquals(Suit.CLUBS, player.getWinCard(Suit.CLUBS, Value.ACE).getSuit());
    }

}
