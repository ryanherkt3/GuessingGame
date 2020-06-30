package guessinggame;

import java.util.Random;

/**
 *
 * @author Ryan
 */
public class GuessingGame 
{
    private static final int UPPER_LIMIT = 101;
    private static Random rand = new Random();
    private static int myNumber;
    private static int guessedNumber;
    
    public static void main(String[] args)
    {
        myNumber = rand.nextInt(UPPER_LIMIT);   //range: 0 and 100
        
        System.out.println("My number, between 0 and 100, is: " + myNumber);
        System.out.println("\n\nYou took " + game(0, UPPER_LIMIT-1) + " guesses!");
    }
    
    public static int game(int lowest, int highest)
    {
        int numGuesses = 0;
        boolean guessed = false;
    
        guessedNumber = (highest-lowest)/2;
        while (!guessed)
        {
            System.out.print("Guess " + (numGuesses+1) + ": " + guessedNumber);
            
            if (guessedNumber < myNumber)
            {
                System.out.print(" Guess is lower than my number\n");
                lowest = guessedNumber;
                guessedNumber += (highest-lowest)/2;
            }
            else if (guessedNumber == myNumber)
                guessed = true;
            else
            {
                System.out.print(" Guess is higher than my number\n");
                highest = guessedNumber;
                guessedNumber -= (highest-lowest)/2;
            }
            ++numGuesses;
        }
        return numGuesses;
    }
}
