import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program called PalChecker checks whether or not a given word is a palindrome
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
public class PalChecker
{

    public static void main(String[] args) throws IOException
    {
        String pali;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please input your palindrome test case");
        pali = input.readLine();
        
        String strippedWord = strippedString(pali);
        String invertedWord = reverse(strippedWord);
        
        if (invertedWord.equals(strippedWord))
            System.out.println("\n" + pali + " IS a palindrome.");
        else
            System.out.println("\n" + pali + " is NOT a palindrome.");

    }
    
    public static String strippedString(String word)
    {
        String newWord;
        newWord = word.replaceAll("[ .,!':;?]", "").toLowerCase();
        return newWord;
    }
    
    public static String reverse(String newWord)
    {
        String output = "";
        String reverseWord = newWord;
        
        while (output.length() < newWord.length())
        {
            output += reverseWord.substring(reverseWord.length()-1);
            reverseWord = reverseWord.substring(0, reverseWord.length()-1);
        }
        
        return output;
        
    }

}
