package sneetches.Casino;


/**
 * Created by willhorton on 1/29/16.
 */
public class Casino {

    private Game game;
    private Player player;

    public void startGame(Player player){
        this.player = player;
        Game game = new Game();
        game.play();




    }

    public int chooseGame() {
        return 1;
    }

}