package sneetches.CasinoSpec;

import org.junit.*;
import static org.junit.Assert.*;
import sneetches.Casino.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by shaungould on 1/30/16.
 */
public class GameSpec {


    Player player;
    Game game;
    @Before
    public void initialize(){
        player = new Player();
        game = new Game(player);
    }

    @Test
    public void getPlayerTest(){
        assertEquals(player, game.getPlayer(0));
    }


}
