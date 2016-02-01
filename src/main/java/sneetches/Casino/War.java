package sneetches.Casino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by willhorton on 1/29/16.
 */


public class War extends CardGame {


    private Player computer = getPlayer(0);

    private Player human = getPlayer(1);
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
        dealHands(26, getPlayer(0));
        dealHands(26, getPlayer(1));

        computer = getPlayer(1);
        computer.setName("Computer");
        human = getPlayer(0);
        human.setName("Human");



        System.out.println("Ready to play? press 1 to start: ");
        int affirmative = 1;        //sc.nextInt();

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

            }


            compareWinnings();
        }

    }

    public void drawPlay(Card h, Card c){
        if (!isHandEmpty(getPlayer(0))) {
            Card compareH = h;
            Card compareC = c;
            int hCardPoints;
            int cCardPoints;
            ArrayList<Card> thePool = new ArrayList<Card>();
            ArrayList<Card> hWarCards;
            ArrayList<Card> cWarCards;
            int last;
            Card hWarCard;
            Card cWarCard;


            while (compareH == compareC) {

                hWarCards = playWarCards(0);
                cWarCards = playWarCards(1);
                thePool.addAll(hWarCards);
                thePool.addAll(cWarCards);
                last = hWarCards.size() - 1;
                hWarCard = hWarCards.get(last);
                cWarCard = cWarCards.get(last);
                compareH = hWarCard;
                compareC = cWarCard;
                hCardPoints = compareH.getPoints();
                cCardPoints = compareC.getPoints();



                if (hCardPoints > cCardPoints) {
                    // when I used the variable human instead of getPlayer(0) it didn't work. why?
                    getPlayer(0).getWinPile().addAll(thePool);
                    System.out.println("Your " + hWarCard.getValue() + " of " + h.getSuit() + " beats computer's " + c.getValue() +
                            " of " + c.getSuit());
                    System.out.println("you added  " + thePool.size() + " cards to your win-pile!!!");
                    break;
                } else if (hCardPoints < cCardPoints) {
                    System.out.println("Computer's " + cWarCard.getValue() + " of " + c.getSuit() + " beats your " + h.getValue() +
                            " of " + h.getSuit());
                    getPlayer(1).getWinPile().addAll(thePool);

                    System.out.println("you just got SPANKED by a computer. It took " + thePool.size() / 2 + " cards from you.");
                    break;
                }

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
