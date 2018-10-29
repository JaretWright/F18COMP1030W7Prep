import java.security.SecureRandom;

/**
 *
 * @author jwright
 */
public class Craps {

    /**
     * Draw a flow chart for this before building it
     */

    /**
     * enums can be used to hold the status of the game (easier to read 1,2,3 AND only
     * gives the user 3 options instead of 4,294,967,294 options with an int
     * */
    private enum Status {CONTINUE, WON, LOST};

    // these constant represent common rolls of the dice with the names used in a casino
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args)
    {
        int myPoint = 0;

        Status gameStatus;  //this can only equal continue, won or lost

        int sumOfDice = rollDice();

        switch (sumOfDice)
        {
            //These are the scenarios where the player wins
            case SEVEN :    //win with a 7 on the first roll
            case YO_LEVEN:  //win with 11 on the first roll
                gameStatus = Status.WON;
                break;

            //These are the scenarios where the player loses
            case SNAKE_EYES:    //lose with a 2 on the first roll
            case TREY:          //lose with a 3 on the first roll
            case BOX_CARS:      //lose with a 12 on the first roll
                gameStatus = Status.LOST;
                break;

            //These are all the other possible outcomes
            default:
                gameStatus = Status.CONTINUE;
                myPoint=sumOfDice;
                System.out.printf("Point is %d%n", myPoint);
                break;
        }

        while (gameStatus == Status.CONTINUE)
        {
            sumOfDice = rollDice(); //roll the dice again

            //if the roll of the dice = your score, you will
            if (sumOfDice == myPoint)
                gameStatus = Status.WON;

            else if (sumOfDice == SEVEN)    //if you roll 7 before your point, you lose
                gameStatus = Status.LOST;
        }   //end of while loop


        //display won or lost message
        if (gameStatus == Status.WON)
            System.out.println("Player wins");
        else
            System.out.println("The house wins");
    }   //end of the main method

    //method to simulate rolling the dice
    public static int rollDice()
    {
        SecureRandom rng = new SecureRandom();
        int die1 = rng.nextInt(6) + 1;
        int die2 = rng.nextInt(6) + 1;

        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, die1+die2);
        return die1 + die2;
    }



}


