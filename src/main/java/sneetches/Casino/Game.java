package sneetches.Casino;

import java.util.ArrayList;

/**
 * Created by willhorton on 1/29/16.
 */
public class Game {

    protected ArrayList<Player> players = new ArrayList<Player>();

    public Game(){

    }

    public Game(Player player){
        players.add(player);
        Player computer = new Player();
        players.add(computer);
    }

    public void announceResult(String message){
        System.out.println(message);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Player getPlayer(int i){
        Player chosenPlayer = players.get(i);
        return chosenPlayer;
    }

    public void play(){

    }
}
