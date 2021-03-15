/**
 * This program uses an array of 1,001 elements to determine and print the prime numbers between 1 and 1,000 (ignore 0)
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
 
public class Primes
{

    public static void main(String[] args)
    {
        int i, j;
        boolean primes[];
        primes = new boolean[1001];
        
        for (i = 0; i < primes.length; i++)
        {
            primes[i] = true;
        }
        
        for (i = 2; i < primes.length;i++)
        {
            for (j = i+1; j < primes.length; j++)
            {
                if(j%i == 0)
                    primes[j] = false;
            }
        }
        
        System.out.println("The list of prime numbers from 1 and 1000 are:\n");
        for (i = 1; i < primes.length; i++)
        {
            if(primes[i] == true)
                System.out.println(i);
        }
        
        System.out.println("End!");

    }

}
