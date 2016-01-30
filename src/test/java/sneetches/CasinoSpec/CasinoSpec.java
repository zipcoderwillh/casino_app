package sneetches.CasinoSpec;
import org.junit.Before;
import org.junit.Test;
import sneetches.Casino.*;
import static org.junit.Assert.*;

/**
 * Created by willhorton on 1/29/16.
 */
public class CasinoSpec {

    Casino casino;
    //Game game;
    Player p1;
    int gameChoice;

    @Before
    public void initialize(){
        casino = new Casino();
        boolean start = false;
        gameChoice = 1;
    }

    @Test
    public void chooseGameTest(){
        casino.chooseGame();

        assertEquals("This will fail, game choice is not expected int", 1, casino.chooseGame());

    }

    @Test
    public void startGameTest(){
        casino.startGame(p1);

    }

}

