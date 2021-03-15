/**
 * This program is an helper class for the CoinToss program.
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
import java.util.*;

enum CoinSide {HEADS, TAILS}
public class Coin
{
    private static Random r = new Random();
    private CoinSide sideUp;
    
    public Coin()
    {                
        sideUp = CoinSide.HEADS;
    }
    public boolean isHeads()
    {
        boolean result;
        if (sideUp == CoinSide.HEADS)
            result = true;
        else
            result = false;
        return result;
        
    }
    public boolean isTails()
    {
       boolean result;
       if (sideUp == CoinSide.TAILS)
           result = true;
       else
           result = false;
       return result;
    }
    public void flip()
    {
        // Generate a random number, either 0 or 1, and use it to set sideUp to HEADS or TAILS
        int randValue = r.nextInt(2);
        if (randValue == 1)
            sideUp = CoinSide.HEADS;
        else
            sideUp = CoinSide.TAILS;
    }
    public String toString()
    {
        return ("Coins side up is: " + sideUp);
    }
}