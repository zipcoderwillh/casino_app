package sneetches.Casino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by willhorton on 1/29/16.
 */


public class War extends CardGame {


    private Player computer = getPlayer(1);

    private Player human = getPlayer(0);
    private boolean gameOver = false;
    private Scanner sc = new Scanner(System.in);




    public War(Player player){
        super(player);
    }






    public void dealDeck(){
        shuffle();
        dealHands(26, getPlayer(0));
        dealHands(26, getPlayer(1));

        /*
        for(int j = 0; j < players.size(); j++) {
            Player currentPlayer = getPlayer(j);
            for(int i = 0; i < 26; i ++) {
                Card randomCard = deck.getRandomCard();
                currentPlayer.addHandCard(randomCard);
            }
        }
           */


    }


    public ArrayList<Card> playWarCards(int i){
        Player targetPlayer = getPlayer(i);
        ArrayList<Card> fourCardPile = new ArrayList<Card>();
        ArrayList<Card> hand = targetPlayer.getHand();
        int handSize = hand.size();
        if(hand.size() > 3) {
            for (int j = 0; j < 4; j++) {

                fourCardPile.add(hand.get(handSize - 1 - j));
                hand.remove(handSize - 1 - j);
            }
        } else {
            int j = 0;
            while (hand.size() > 0) {

                fourCardPile.add(hand.get(handSize - 1 - j));
                hand.remove(handSize - 1 - j);
                j++;
            }
        }

        return fourCardPile;
    }

    public void play(){

        Game.startCardGameArt();

        dealHands(26, getPlayer(0));
        dealHands(26, getPlayer(1));

        computer = getPlayer(1);
        computer.setName("Computer");
        human = getPlayer(0);
        human.setName("Human");



        System.out.println("Ready to play? press 1 to start: ");
        int affirmative = sc.nextInt();
        sc.nextLine();

        if (affirmative == 1) {

            while (!gameOver) {
                int hTopIndex = getPlayer(0).getHandSize() - 1;
                Card hDraw = getPlayer(0).getHandCard(hTopIndex);
                int cTopIndex = getPlayer(1).getHandSize() - 1;
                Card cDraw = getPlayer(1).getHandCard(cTopIndex);


                if (hDraw.getPoints() > cDraw.getPoints()){
                    normPlay(hDraw, cDraw);

                } else if (hDraw.getPoints() < cDraw.getPoints()) {
                    normPlay(hDraw, cDraw);

                } else {
                    if (isHandEmpty(getPlayer(0))){
                        break;
                    }
                    System.out.println("It's war! 1 2 3 War!");
                    drawPlay(hDraw, cDraw);

                }
                if (isHandEmpty(getPlayer(0))){
                    gameOver = true;
                }
                pause();
            }


            compareWinnings();
        }

        Game.endGameArt();

    }

    // Stop game until "return" is pressed to allow an actual person time to read what's going on
    public void pause() {
        String input = null;
        while(input == null) {
            System.out.println("Press <RETURN> to continue...");
            input = sc.nextLine();
        }
    }

    public void drawPlay(Card h, Card c){
        int compareH = h.getPoints();
        int compareC = c.getPoints();
        ArrayList<Card> thePool = new ArrayList<Card>();


        while(compareH == compareC) {
            if (!isHandEmpty(getPlayer(0))) {
                ArrayList<Card> hWarCards = playWarCards(0);
                ArrayList<Card> cWarCards = playWarCards(1);
                thePool.addAll(hWarCards);
                thePool.addAll(cWarCards);
                int last = hWarCards.size() - 1;
                Card hWarCard = hWarCards.get(last);
                Card cWarCard = cWarCards.get(last);
                compareH = hWarCard.getPoints();
                compareC = cWarCard.getPoints();

            }

            if (compareH > compareC) {
                // when I used the variable human instead of getPlayer(0) it didn't work. why?
                getPlayer(0).getWinPile().addAll(thePool);

                System.out.println("you added  " + thePool.size() + " cards to your win-pile!!!");
                //break;
            } else {

                getPlayer(1).getWinPile().addAll(thePool);

                System.out.println("you just got SPANKED by a computer. It took " + thePool.size() / 2 + " cards from you.");
                //break;
            }

        }

    }


    public void normPlay(Card h, Card c){
        human.setName("human");
        computer.setName("computer");
        ArrayList<Card> thePool = new ArrayList<Card>();
        int hVal = h.getPoints();
        int cVal = c.getPoints();

        human.getHand().remove(human.getHandSize() - 1);
        computer.getHand().remove(computer.getHandSize() - 1);
        thePool.add(h);
        thePool.add(c);

        if (hVal > cVal){
            getPlayer(0).getWinPile().addAll(thePool);
            System.out.println("Your " + h.getValue() + " of " + h.getSuit() + " beats computer's " + c.getValue() +
                    " of " + c.getSuit());
            System.out.println(getPlayer(0).getName() + " is the winner! They have a win-pile of " + getPlayer(0).getWinPile().size() + " cards.");

        } else {
            getPlayer(1).getWinPile().addAll(thePool);
            System.out.println("Computer's " + h.getValue() + " of " + h.getSuit() + " beats your " + c.getValue() +
                    " of " + c.getSuit());
            System.out.println(getPlayer(1).getName() + " is the winner! They have a win-pile of " + getPlayer(1).getWinPile().size() + " cards.");
        }



    }


    public Player compareWinnings(){
        Player human = getPlayer(0);
        human.setName("human");
        Player computer = getPlayer(1);
        computer.setName("computer");

        if(getPlayer(0).getWinPile().size()>getPlayer(1).getWinPile().size()){
            System.out.println(human.getName() + " wins with a pile of " + human.getWinPile().size() + " cards, beating " +
                    "computer's pile of " + computer.getWinPile().size() + " cards!!!!");
            return getPlayer(0);
        } else {
            System.out.println(computer.getName() + " wins with a pile of " + computer.getWinPile().size() + " cards, beating " +
                    "your pile of " + human.getWinPile().size() + " cards!!!!");
            return getPlayer(1);
        }
    }


}
