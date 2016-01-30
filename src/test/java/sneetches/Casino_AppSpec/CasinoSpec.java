package sneetches.Casino_AppSpec;
import org.junit.Before;
import org.junit.Test;
import sneetches.Casino.*;
import static org.junit.Assert.*;

/**
 * Created by willhorton on 1/29/16.
 */
public class CasinoSpec {

    Casino casino;
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

}

