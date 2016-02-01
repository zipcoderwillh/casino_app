package sneetches.Casino;

/**
 * Created by michaelgraham on 1/30/16.
 */
import java.util.*;

public class streetCraps {



    public static void main(String[] args) { 
        int die1;
        int die2;
        die1 = (int) (Math.random() * 6) + 1;                           //Each die has 6 sides with a number 1-6
        die2 = (int) (Math.random() * 6) + 1; 
        int throw1, throw2;                                           //throw1 = come out roll
        throw1 = die1 + die2;


        System.out.println(); 
        System.out.print("You threw " + throw1 + ". ");              //Each round has two phases: Come Out and Point.

        if (throw1 == 2 || throw1 == 3 || throw1 == 12) {           //come out roll

            System.out.println("You crapped out!");                //To crap out is to roll 2, 3 or 12 on come out roll

        } else if (throw1 == 7 || throw1 == 11) {                 //To pass is to roll a 7 or 11 on the come out roll

            System.out.println("You passed!"); 

        } else  {
            System.out.println("Point is " + throw2 + "\n");         //Point: 4, 5, 6, 8, 9, 10
            die1 = (int) (Math.random() * 6) + 1; 
            die2 = (int) (Math.random() * 6) + 1; 
            System.out.print("You threw " + throw2 + ". ");  }

        while (throw2 != 7)

        {


            if (throw == throw2) { 
            System.out.println("You Won!");
        }
             break; 


            else{ 

            System.out.println("Point is " + throw2 + "\n"); 
        }
             die1 = (int) (Math.random() * 6) + 1; 

            die2 = (int) (Math.random() * 6) + 1; 


            System.out.print("You threw " + throw2 + ". "); 
        } 

        if (throw2 == 7) { 
            System.out.println("You Lose!"); 
        } }
     

    public void play() {

    }

    public int throwDice() {
        return 0;
    }
}