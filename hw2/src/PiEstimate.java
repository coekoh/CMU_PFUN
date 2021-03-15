import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * This program calculates the value of pi from the infinite series
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
public class PiEstimate
{
    

    public static void main(String[] args) throws IOException
    {
        String nTerms; int num;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please enter the number of terms you wish to calculate for the sequence:");
        nTerms = input.readLine();
        num = Integer.parseInt(nTerms);       
        
        sequenceCalc(num);
    }
    
    public static void sequenceCalc(int num)
    {
        System.out.println("         Output         ");
        System.out.println("============================");
        double pi = 0;
        int N = 0;
        int pattern = 0;
        int number = 0;
        for (double i = 1; i <= num; i++)
        {
            pi += Math.pow(-1, i)*(-4/(1 + 2*(i -1))); 
            N+=1;
            
            if (i <= 5)
            {
                System.out.println(N + ": " + pi);
                System.out.println("============================");
            }
            
            else if (i > num-5)
            {
                System.out.println(N + ": " + pi);
                System.out.println("============================");
            }
            
            if (Math.floor(pi*100000) == 314159)
            {
               pattern += 1;
               if (pattern == 1)
               {
                   number = N-1;
               }
            }
        }
        if (number >  0)
        {
            System.out.println("\nSearched for 3.14159, found after " + number + " terms");
        }
        else
        {
            System.out.println("\nSearched for 3.14159, not found after " + N + " terms"); 
        }
        System.out.println("\nPi for "+ N + " terms is " + pi);
    }
}
