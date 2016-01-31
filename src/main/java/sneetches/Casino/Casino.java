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

        // Commented out for now because does not compile as is (GoFish, War, StreetCraps all need to be set up to take Player parameter)
        /*
        switch (playerChoice) {
            case 1:
                game = new GoFish(player);
                System.out.println("You're playing Go Fish!");
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

        Scanner sc = new Scanner(System.in);
        int result = 0;

        while(result == 0) {
            System.out.println("Please choose a game. Enter 1 for Street Craps, 2 for War, or 3 for Go Fish:");
            String input = sc.nextLine();
            if(input.matches("[1-3]")) {
                result = Integer.parseInt(input);
                break;
            }
            System.out.println("Invalid input. Only numbers 1 - 3 accepted.");
        }

        return result;

    }

    public static void main(String[] args) {

        Casino casinoGame = new Casino();
        casinoGame.startGame();

    }

}