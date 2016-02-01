/**
 * Created by michaelgraham on 1/30/16.
 */

package sneetches.Casino;

import java.util.*;

public class StreetCraps extends Game {

    private Player computer;
    private Player human;
    private Scanner sc = new Scanner(System.in);

    public StreetCraps(Player player) {

        super(player);
    }

    public void play() {
        System.out.println("Enter your name");
        String input = sc.nextLine();

        computer = getPlayer(0);
        computer.setName("Computer");
        human = getPlayer(1);
        human.setName(input);

        if (roundOne(human) && roundOne(computer)) {
            roundTwo(human);

            if(human.getScore() != 2) {
                roundTwo(computer);
            }
        }
        else {
            return;
        }


        if(computer.getScore() == 2) {
            return;
        }

        else if(human.getScore() > computer.getScore())
        {
            System.out.println("human won!");
        }
        else if(computer.getScore() > human.getScore()) {
            System.out.println("computer won!");
        }
        else {
            System.out.println("It's a draw!");
        }

    }

    public boolean roundOne(Player player)  {
        int throw1 = throwDice();
        boolean gameOver = false;
        String playerName = player.getName();

        System.out.println();
        System.out.print(playerName + " threw " + throw1 + ". ");            //Each round has two phases: Come Out and Point.

        if (throw1 == 2 || throw1 == 3 || throw1 == 12) {         //come out roll

            System.out.println(playerName + " crapped out, Game Over!");
            //To crap out is to roll 2, 3 or 12 on come out roll

        } else if (throw1 == 7 || throw1 == 11) {              //To pass is to roll a 7 or 11 on the come out roll

            System.out.println(playerName + " passed, nice try!");

        } else {
            gameOver = true;
            System.out.println(playerName + " rolled a point, your score is " + throw1 + "\nYou're going to round 2!");      //Point: 4, 5, 6, 8, 9, 10
        }
        return gameOver;
    }

    public void roundTwo(Player player) {
    String playerName = player.getName();
        int throw2 = throwDice();

        if (throw2 == 7) {
            System.out.println(playerName + " Won!");
        }
        else if(throw2 == 2) {
            System.out.println(playerName + " Lose!");
        }
        else {
            System.out.println(playerName + " rolled " + throw2 + " points!");
            player.setScore(throw2);
        }
    }

    public int throwDice() {

        int die1;
        int die2;
        die1 = (int) (Math.random() * 6) + 1;                       //Each die has 6 sides with a number 1-6
        die2 = (int) (Math.random() * 6) + 1;

        return die1 + die2;

    }

    public static void main(String[] args) {
        Player humanPlayer = new Player();
        StreetCraps testGame = new StreetCraps(humanPlayer);
        testGame.play();
    }

}