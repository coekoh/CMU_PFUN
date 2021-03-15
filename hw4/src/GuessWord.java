import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program is a game where there is a secret phrase the user tries to guess. 
 * For every letter guessed, a character that matches uncovers in the secret string
 *
 * @author Courage Ekoh
 * @author Safari Liberateur
 *
 * Andrew ID: coekoh
 * Andrew ID: sliberat
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class GuessWord
{

    public static void main(String[] args) throws IOException
    {        
        String str;
        int counter;
        
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
        PhraseList phrases = new PhraseList(args[0]);
        phrases.addPhrase("Courage and Safari!");
        
        System.out.println("**************************************************************\r\n"
                + "Welcome to Courage and Safari's fabulous word-guessing game!\n"
                + "**************************************************************\n");
        
        System.out.print("Would you like to play? ");
        str = keyboard.readLine();
        
        while (checkForYes(str) == true)
        {
            SecretString guessWord = new SecretString(phrases.getRandomPhrase());
            System.out.println(guessWord);
            
            System.out.print("Guess the Phrase: ");
            str = keyboard.readLine();
            counter = 1;
            while (guessWord.equals(str) == false)
            {
                counter++;
                System.out.println("\nNo, that's not it.");
                System.out.print("\nGuess a letter: ");
                str = keyboard.readLine();
                
                             
                if (guessWord.reveal(str) == 1)
                {
                    System.out.println("\nThere is " + guessWord.reveal(str) + " \"" + str +"\"" );
                }
                else
                {
                    System.out.println("\nThere are " + guessWord.reveal(str) + " \"" + str +"\"s" );
                }
                System.out.println("\n" + guessWord);
                
                System.out.print("Guess the Phrase: ");
                str = keyboard.readLine();
            }
            
            System.out.println("\n**Yes, that's it!, You guessed it in " + counter + " tries!\n");
            System.out.print("**************************************************************\n"
                    + "Would you like to play again? ");
            str = keyboard.readLine();
        }
        
        System.out.println("**************************************************************\r\n"
                + "Thanks for playing Courage and Safari's word-guessing game!\n"
                + "**************************************************************");
        

    }
    
    public static boolean checkForYes(String str)
    {
        //This method evaluates input to see if the user types a yes
        boolean result;
        if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("yep"))
            result = true;
        else
            result = false;
        return result;
    }

}
