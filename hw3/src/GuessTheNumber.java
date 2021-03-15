 /**
 * This program is called provides a random number and allows the user to guess the number
 * and records the number of attempt the user uses in guessing the number
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

import java.io.*;
import java.util.*;

public class GuessTheNumber
{
    static Random r = new Random();
    
    public static int guess(int maxRange, BufferedReader keyboard) throws IOException
    {
        int guess, number, numGuesses = 0;
        String str;
        number = 1 + r.nextInt(maxRange);
        
        while (true)
        {
            str = keyboard.readLine();
            guess = Integer.parseInt(str);            
            numGuesses++;
            if (guess == number)
                break;
            
            if (guess < number)
                System.out.print("Too Low, ");
            else
                System.out.print("Too high, ");
            
            System.out.println("Try again: ");
        }
        
        return numGuesses;
        
    }
    
    public static int log2(int n)
    {
        int result;
        result = (int) Math.round(Math.log10(n) / Math.log10(2.));
        return result;
    }
    
    public static boolean checkForSpace(String str)
    {
        boolean result;
        String strip;
        
        strip = str.replaceAll("[\\s\\t]", "");
        
        if (strip.length() == 0)
            result = true;
        else
            result = false;
        
        return result;
    }
    
    public static boolean checkForYes(String str)
    {
        boolean result;
        if (str.equals("y") || str.equals("yes") || str.equals("yep") || checkForSpace(str) == true)
            result = true;
        else
            result = false;
        return result;
    }

    public static void main(String[] args) throws IOException
    {
        
        String name;
        String str;
        int maxRange;
        int numGuesses;
        
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
        name = promptForName(keyboard);
        maxRange = 1+ r.nextInt(1000);
        
        System.out.print("\nHi " + name + ". I am thinking of a number from 1-" + maxRange + " -guess the number: ");
        

        numGuesses = guess(maxRange, keyboard);
        
        
        System.out.println("\nCongratulations, you guessed the number in " + numGuesses +"!");
        System.out.println("Thanks for playing my Guess-the-Number Game " + name + "!");
        
        if (numGuesses <= log2(maxRange))
            System.out.println("You know the secret");
        else
            System.out.println("You should be able to do better!"); 
            
        
        System.out.println("\nDo you want toplay the game again? ");
        str = keyboard.readLine();
        
        while (checkForYes(str) == true)
        {
            maxRange = 1+ r.nextInt(1000);
            System.out.print("Hi " + name + ". I am thinking of a number from 1-" + maxRange + " -guess the number: ");
            numGuesses = guess(maxRange, keyboard);
            System.out.println("Congratulations, you guessed the number in " + numGuesses +"!");
            
            if (numGuesses <= log2(maxRange))
                System.out.println("You know the secret");
            else
                System.out.println("You should be able to do better!"); 
                
            System.out.println("Do you want toplay the game again? ");
            str = keyboard.readLine();
        }
        
        System.out.println("Thanks for playing my Guess-the-Number Game " + name + "!");
        
        

    }
    
    public static String promptForName(BufferedReader keyboard) throws IOException
    {
        String name;
        System.out.print("Please enter your name: ");
        name = keyboard.readLine();
        
        return name;
    }

}
