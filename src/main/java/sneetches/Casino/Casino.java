package sneetches.Casino;


import java.util.Scanner;

/**
 * Created by willhorton on 1/29/16.
 */
public class Casino {


    public void startGame() {
        Game game = new Game();
       /* Game goFish = new GoFish();
        Game war = new War();
        Game craps = new StreetCraps();*/

        switch (game) {
            case 1:
                Game goFish = new goFish();
                System.out.println("You're playing go fish!");
                goFish.play();
                break;
            case 2:
                Game war = new war();
                System.out.println("You're playing war!");
                war.play();
                break;
            case 3:
                Game craps = new streetCraps();
                System.out.println("You're playing Street Craps!");
                streetCraps.play();
                break;
            default:
                Game goFish2 = new goFish();
                System.out.println("You didn't make a valid choice, so you're playing go fish!");
                goFish2.play();
                break;
        }
    }

    public int chooseGame() {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }

    public static void main(String[] args) {

        Casino casinoGame = new Casino();
        casinoGame.startGame();
    }

}
}