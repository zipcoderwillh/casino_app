package sneetches.CasinoSpec;

import org.junit.*;
import static org.junit.Assert.*;
import sneetches.Casino.*;

/**
 * Created by willhorton on 1/29/16.
 */
public class CardGameSpec {

    CardGame cardGame;

    @Before
    public void initialize() {
        cardGame = new CardGame();
    }

    @Test
    public void isDeckEmptyTest() {
        assertEquals(true,cardGame.isDeckEmpty());
    }

    @Test
    public void isHandEmptyTest() {
        assertEquals(true, cardGame.isHandEmpty());
    }
}
