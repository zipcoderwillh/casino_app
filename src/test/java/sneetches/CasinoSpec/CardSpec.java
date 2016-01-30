package sneetches.CasinoSpec;

import org.junit.*;
import static org.junit.Assert.*;
import sneetches.Casino.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by willhorton on 1/30/16.
 */
public class CardSpec {

        Card testCard1;
        Card testCard2;
        Card testCard3;
        Card testCard4;

        @Before
        public void initialize() {
            testCard1 = new Card(Suit.CLUBS, Value.QUEEN);
            testCard2 = new Card(Suit.HEARTS, Value.TWO);
            testCard3 = new Card(Suit.DIAMONDS, Value.FIVE);
            testCard4 = new Card(Suit.SPADES, Value.TEN);
        }

        @Test
        public void cardTest() {

            // testCard1 for suit, value, and points getters
            assertEquals(Suit.CLUBS, testCard1.getSuit());
            assertEquals(Value.QUEEN, testCard1.getValue());
            assertEquals(12, testCard1.getPoints());

            // testCard2
            assertEquals(Suit.HEARTS, testCard2.getSuit());
            assertEquals(Value.TWO, testCard2.getValue());
            assertEquals(2, testCard2.getPoints());

            // testCard3
            assertEquals(Suit.DIAMONDS, testCard3.getSuit());
            assertEquals(Value.FIVE, testCard3.getValue());
            assertEquals(5, testCard3.getPoints());

            // testCard4
            assertEquals(Suit.SPADES, testCard4.getSuit());
            assertEquals(Value.TEN, testCard4.getValue());
            assertEquals(10, testCard4.getPoints());

        }

}
