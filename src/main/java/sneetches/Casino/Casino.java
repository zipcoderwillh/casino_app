package sneetches.Casino;


import java.util.Scanner;

/**
 * Created by willhorton on 1/29/16.
 */
public class Casino {

    public void startGame() {

        Game game = null;
        Player player = new Player();
        int playerChoice = chooseGame();

        // Commented out because GoFish, War, and StreetCraps need to be modified to take Player parameters
        /*
        switch (playerChoice) {
            case 1:
                game = new GoFish(player);
                System.out.println("You're playing go fish!");
                break;
            case 2:
                game = new War(player);
                System.out.println("You're playing war!");
                break;
            case 3:
                game = new StreetCraps(player);
                System.out.println("You're playing Street Craps!");
                break;
        }
        */

        game.play();

    }

    public int chooseGame() {

        Scanner in = new Scanner(System.in);
        int choice = 0;

        while(choice == 0) {
            System.out.println("Please choose a game. Enter 1 for Go Fish, 2 for War, or 3 for Street Craps:");
            String input = in.nextLine();
            if(input.matches("[1-3]")) {
                choice = Integer.parseInt(input);
                break;
            }
            System.out.println("Invalid input. Only 1, 2, or 3 accepted.");
        }


        return choice;

    }

    public static void main(String[] args) {

        Casino casinoGame = new Casino();
        casinoGame.startGame();

    }

}
