import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program calculates the sum of all integers that are divisible by 3, from 1 to N
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
public class Sum3
{

    public static void main(String[] args) throws IOException
    {
        int num;
        String number;
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Please enter an integer you wish to sum up to for multiples of 3: ");
        
        number = input.readLine();
        while (number.equals("") || number.matches("[.a-zA-Z]*") || Double.parseDouble(number)%1 != 0)
        {   
            System.out.print("Please enter an integer: ");
            number = input.readLine();
        }
        
        num = Integer.parseInt(number);
        while (num != -1)
        {
            System.out.println("Sum3 for the number " + num + " is: " + sum_integers(num) );
            System.out.print("\nKindly enter another number you wish to sum up to for multiples of 3: ");
            number = input.readLine();
            while (number.equals("") || number.matches("[.a-zA-Z]*") || Double.parseDouble(number)%1 != 0)
            {   
                System.out.print("Please enter an Integer: ");
                number = input.readLine();
            }
            num = Integer.parseInt(number);
        }
        
        System.out.println("\nEnd of Program!!!");
    }
    
    public static int sum_integers(int n)
    {
        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            if (i % 3 == 0)
            {
                sum += i;
            }
        } 
        return sum;
    }

}
