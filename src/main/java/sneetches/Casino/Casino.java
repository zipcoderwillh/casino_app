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

    public void art(){
        System.out.println(" _    _      _                          _ \n" +
                "| |  | |    | |                        | |\n" +
                "| |  | | ___| | ___ ___  _ __ ___   ___| |\n" +
                "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ |\n" +
                "\\  /\\  /  __/ | (_| (_) | | | | | |  __/_|\n" +
                " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___(_)\n" +
                "                                          \n" +
                "                                          ");
        System.out.println("\n" +
                "                                                                                    \n" +
                "                                                                                    \n" +
                "       \"-                                                                           \n" +
                "         └,, ┐                                                                      \n" +
                "      `─-   ╞ `ç                                                                    \n" +
                "          b   ⁿ╕╙                                                                   \n" +
                "         }   ^*╕╙▄╕                                                                 \n" +
                "      ▒9      ?²╨╣▓                                                                 \n" +
                "      ▌░δ▄  .╔╗S▒Å▓▒╦                                                               \n" +
                "      └Q░ÅÅ╦,▓▓▄▄▒^▄Θ▌                                                              \n" +
                "       ╙╣░░░δ▐▀▀▐▓▌▀░▓Γ                                                             \n" +
                "         ╙╦░░░░░░▐░░▄▀                                                              \n" +
                "            ^²╜▄▒▓%╬▓╫                                                              \n" +
                "               ▓╒▌░░█▓▀                                                             \n" +
                "              ▌▓▄▄▄Ñ▄▀                                                              \n" +
                "                 ▌░▐                                                                \n" +
                "                 ▌▓▓                                                                \n" +
                "                .▓▓▌Q                                                               \n" +
                "                 ▀ƒ▌\"                                                               \n" +
                "                ▐▀▓▌                                                                \n" +
                "                ▐█▓▓▌                                                               \n" +
                "                ▀▀░▀▐▄                                                              \n" +
                "                  ▌j∩▀Θ\"╦                                                           \n" +
                "                 ƒ ▀` ]wƒ▄#▓Ü                                                       \n" +
                "                Γ╠▀Γ▐▀M▌░δ▀░░Σ╦                                                     \n" +
                "                ╒Θƒ░Γ░░░░░░░░Σ▒▄B#▄╦⌐                                               \n" +
                "               ,▀▄Θ░░░QQ░░░░░░░Γ█▓▓▓▓▓▄▄▓▒▄ ,,▄#▓Γ                                  \n" +
                "             ▄Θ░▓▓░░░░G▄═░░░░░░░░░▀█▀█▓▓█▓▓▌░╣ΦΓ                                    \n" +
                "          µ╪▀░▄▓█▌░░░░qqΦ═░░░░░░░░░░δ╦ ▀▀▌▓▀▓▓▌▒╦                                   \n" +
                "        ╒Σ░░░ΓΓΓR▌▄▄▄▄░╤#ôF░░░░░░░░░░δ▓╕  █ ▀▓▄ `▀▀▄,                               \n" +
                "          ╙▀▄Q▒░R▄░▀▌¼░╪Σ▒▒S░░░░░░░░░░░▒      ╙▀                                    \n" +
                "             <▌╩█╨╩█à▓▓░▒δδΘ▒▀╢░░░░░░░░░▒┐                                          \n" +
                "                  ▒░╩╢▄▓▓▀▄▓▄▄QQ▐░░░░e░╔▀                                           \n" +
                "                   ▒▄▒▒▀▓▒╢▀▌╫Q▄╬░░░░▄░½▌                                           \n" +
                "                    ▀▄▒▒▀▓▀██▒▒▒▒KQ░░Φ░▐                                            \n" +
                "                      ╙▄▀▒▄Θ▀▀δδΘ░▒æ░░░▓                                            \n" +
                "                         ╙▓▀▓δ▒Q▄▄╬▒φ░▀                                             \n" +
                "                     {Ü░▒▄▌▒▀▀▀Γ▀▀▀▀▀▒▄ΓÉWæ╤,                                       \n" +
                "                      τ▒░░▒             ▓▀ΘQ#                                       \n" +
                "                  ╓@ÉΣΣ▒▀▀ñΓΣ9▄       ╬░SÅ▀ÉÉS≈╕                                    \n" +
                "                        Γ ΓΓ``Γ       `\"ΦΣΓΓ `^┴¥╩M       ");

    }

    public static void main(String[] args) {

        Casino casinoGame = new Casino();
        casinoGame.art();
        casinoGame.startGame();

    }

}
