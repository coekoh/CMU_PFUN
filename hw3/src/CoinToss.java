/**
 * This program takes an integer from command line arguments 
 * and then flips a coin for that number of times,
 * returns numbers of heads and tails
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
public class CoinToss
{

    public static void main(String[] args)
    {
        int i, j, numOfFlips, heads, tails;
        Coin coinTest = new Coin();
        
        
        
        for (j = 0; j < args.length; j++)
        {
            heads = 0; tails = 0;
            numOfFlips = Integer.parseInt(args[j]);
            
            for (i = 0; i < numOfFlips; i++)
            {
                coinTest.flip();
                if (coinTest.isHeads() == true)
                    heads++;
                else
                    tails++;
            }
            
            System.out.println("Tossed a coin " + numOfFlips + " times.");
            System.out.println("Heads: " + heads + " Tails: " + tails);
            System.out.println("Heads: " + formatPercent(heads, numOfFlips) + " Tails: " + 
                    formatPercent(tails, numOfFlips));
            System.out.println("");
        }
        
        
    }
    
    public static String formatPercent(int givenNum, int totalNum)
    {
        String str;
        int percent;
        
        percent = (int) Math.round((double)givenNum/totalNum*100);
        str = percent + "%";
        return str;
    }


}
