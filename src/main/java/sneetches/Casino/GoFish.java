package sneetches.Casino;

import java.util.*;

/**
 * Created by willhorton on 1/29/16.
 */
public class GoFish extends CardGame {

    private Player computer;
    private Player human;
    private boolean gameOver = false;
    private Scanner sc = new Scanner(System.in);

    public GoFish(Player player) {
        super(player);
    }

    public void play(){

        // Deal seven cards to each player
        for(Player currentPlayer : players) {
            for(int i = 0; i < 7; i ++) {
                Card randomCard = deck.getRandomCard();
                currentPlayer.addHandCard(randomCard);
            }
        }

        // Assign names so we can tell human from computer
        computer = getPlayer(0);
        computer.setName("Computer");
        human = getPlayer(1);
        human.setName("Human");

        // Alternate turns until deck runs out
        while(gameOver == false) {
            takeTurn(human);
            takeTurn(computer);
        }

        System.out.println("********************\n     Game over!\n*******************");

        // Print out win piles (if any)
        if(human.getWinPile().size() > 0) {
            System.out.println("Here is your win pile:");
            for(Card card : human.getWinPile()) {
                System.out.printf("%-5s of %s\n", card.getValue(), card.getSuit());
            }
        }
        else {
            System.out.println("Sorry, you have nothing in your win pile.");
        }

        if(computer.getWinPile().size() > 0) {
            System.out.println("*******************\nHere is computer's win pile:");
            for(Card card : computer.getWinPile()) {
                System.out.printf("%-5s of %s\n", card.getValue(), card.getSuit());
            }
        }
        else {
            System.out.println("Computer has nothing in its win pile.");
        }

        System.out.println("**************************\nAnd the final result is...\n*************************");

        // Count how many sets of four each player has. Compare them. If the same, declare tie. If not, declare winner and exit game.
        String winner = "";
        if(human.getWinPile().size() == computer.getWinPile().size()) {
            System.out.println("It's a tie!");
        }
        else {
            winner = human.getWinPile().size() / 4 > computer.getWinPile().size() / 4 ? "Human" : "Computer";
            System.out.printf("%s wins the game!\n", winner);
        }

        /*
        This doesn't work, need to figure out why or just end the game at the end.
        String input = null;
        while(input == null) {
            System.out.println("**************************\nPlay again (press y or n)?");
            input = sc.nextLine();
            if (input.matches("^[yn]$")) {
                if (input.equals("y")) {
                    play();
                } else {
                    return;
                }
            }
            System.out.println("Invalid input. Please enter y or n.");
        }
        */

        return;

    }

    public void takeTurn(Player player) {

        String playersName = player.getName();
        String otherPlayersName = player.getName().equals("Computer") ? "Human" : "Computer";
        String input = null;
        ArrayList<Card> cardsFromOtherPlayer = new ArrayList<Card>();

        sortHand(player.getHand());

        if(playersName.equals("Human")) {
            // Print out humans's hand
            System.out.printf("Here is your current hand:\n");
            for(Card card : player.getHand()) {
                System.out.printf("%-5s of %s\n", card.getValue(), card.getSuit());
            }
            // Get input for what human wants to ask computer for
            while (true) {
                System.out.println("Enter a rank of card to ask for (e.g. six, jack, ace, etc.):");
                input = sc.nextLine().toUpperCase();
                if (input.matches("^(TWO)|(THREE)|(FOUR)|(FIVE)|(SIX)|(SEVEN)|(EIGHT)|(NINE)|(TEN)|(JACK)|(QUEEN)|(KING)|(ACE)$")) {
                    break;
                }
                System.out.println("Invalid input.");
            }
            // Ask computer for cards
            cardsFromOtherPlayer = askOtherPlayer(input, computer);
        }
        else {
            // If not human, generate a random card value and see if human has it
            input = Value.getRandomValue().toString();
            System.out.printf("Computer says: give me all your %ss\n", input);
            cardsFromOtherPlayer = askOtherPlayer(input, human);
        }

        // If other player doesn't have any, get a new random card and add to player's hand
        if(cardsFromOtherPlayer == null) {
            System.out.printf("Sorry %s, %s does not have any %ss. Go fish!\n", playersName, otherPlayersName, input);
            Card newCard = deck.getRandomCard();
            if(newCard == null) {
                gameOver = true;
                return;
            }
            if(playersName.equals("Human")) {
                System.out.printf("You drew the %s of %ss\n", newCard.getValue(), newCard.getSuit());
            }
            else {
                System.out.println("Computer is drawing a new card");
            }
            player.addHandCard(newCard);
            sortHand(player.getHand());
            pause();
        }
        else {
            // If other player does have card(s), show them and add to player's hand
            for(Card card : cardsFromOtherPlayer) {
                System.out.printf("%s gave %s the %s of %s\n", otherPlayersName, playersName, card.getValue(), card.getSuit());
                player.addHandCard(card);
                sortHand(player.getHand());
            }
            pause();
        }

        // Check if player has four of a kind in hand
        ArrayList<Card> fourOfAKind = checkFourOfAKind(player.getHand());
        if(fourOfAKind.size() > 0) {
            System.out.println("*******************");
            System.out.printf("%s collected four of a kind!\n*******************\nThe following cards have been taken from %s's hand and added to their win pile:\n", playersName, playersName);
            for(Card card : fourOfAKind) {
                System.out.printf("%-5s of %s\n", card.getValue(), card.getSuit());
                player.addWinCard(card);
            }
            pause();
        }

        // Check if any cards remain in hand. If not, try to get new card from deck. If deck is empty, set gameOver
        // to true and return to play(). Otherwise, put new card in hand and return to play().
        if(player.getHand().size() == 0) {
            Card newCard = deck.getRandomCard();
            if(newCard == null) {
                gameOver = true;
                return;
            }
            else {
                player.addHandCard(newCard);
            }
        }

    }

    // Stop game until "return" is pressed to allow an actual person time to read what's going on
    public void pause() {
        String input = null;
        while(input == null) {
            System.out.println("Press <RETURN> to continue...");
            input = sc.nextLine();
        }
    }

    // Sort cards by ascending order of their point values (i.e. TWO - ACE). This makes it easier to find
    // out if a player has four of a kind in the following method (extending David's algorithm for finding duplicates
    // from class the other day.
    // In order to sort based on each Card's Value enum, had to implement a custom Comparator (I think).
    // See https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
    public void sortHand(ArrayList<Card> originalList) {
        Collections.sort(originalList, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                int result = 0;
                if(o1.getPoints() == o2.getPoints()) {
                    result = 0;
                }
                else {
                    result = o1.getPoints() > o2.getPoints() ? 1 : -1;
                }
                return result;
            }
        });
    }

    // At end of each turn check if there is a set of four in current player's hand.
    // If so, add it to win pile.
    public ArrayList<Card> checkFourOfAKind(ArrayList<Card> hand) {

        ArrayList<Card> result = new ArrayList<Card>();

        boolean tracking = false;
        int startPointer = 0;
        int endPointer = 0;
        for(int i = 0; i < hand.size() - 1; i++) {
            if(hand.get(i).getValue() == hand.get(i + 1).getValue()) {
                if(!tracking) {
                    tracking = true;
                    startPointer = i;
                    endPointer = i + 1;
                }
                else if (tracking) {
                    endPointer = i + 1;
                    if(endPointer - startPointer == 3) {
                        result.addAll(hand.subList(startPointer, endPointer + 1));
                        hand.removeAll(hand.subList(startPointer, endPointer + 1));
                        break;
                    }
                }
                else {
                    endPointer = i + 1;
                }
            }
            else {
                tracking = false;
            }
        }

        return result;

    }

    // Search for card in other player's hand that matches input, remove it from other player's hand, and return it
    // Return null if not in other player's hand
    public ArrayList<Card> askOtherPlayer(String input, Player otherPlayer){

        ArrayList<Card> foundCards = new ArrayList<Card>();
        ArrayList<Card> otherPlayersCards = otherPlayer.getHand();

        // The only way to remove an element from a collection while iterating over it is to use an explicitly
        // declared iterator. Trying to do this with foreach construct will throw a ConcurrentModificationException.
        // See http://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
        for( Iterator<Card> it = otherPlayersCards.iterator(); it.hasNext(); ) {
            Card card = it.next();
            if(card.getValue().toString().equals(input)) {
                foundCards.add(card);
                it.remove();
            }
        }

        if(foundCards.size() == 0) return null;

        return foundCards;
    }

    public static void main(String[] args) {
        Player humanPlayer = new Player();
        GoFish testGame = new GoFish(humanPlayer);
        testGame.play();
    }

}