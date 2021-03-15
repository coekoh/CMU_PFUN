import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program demonstrates the concept of exceptions in java
 *
 * @author Courage Ekoh , Peter Mukasa Mukooza, Percy Chukwudi, Jean Paul Tuyisenge, Safari Liberateur
 *
 * Andrew ID: coekoh, pmukooza, pchukwud, jtuyisen, sliberat
 * 
 * On our honor, as Carnegie-Mellon Africa students, we have neither given nor received unauthorized assistance on this work
 *
 */


public class Exception2
{

    public static void main(String[] args)
    {
        
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
        String str;
        int x;

        try
        {
            str = keyboard.readLine();
            x = Integer.parseInt(str);
        }
        
        catch (NumberFormatException e)
        {
            System.out.println("Input not appropriate");
            x = 0;
        }
        
        catch (IOException e)
        {
            System.out.println("IOException");
        }

    }

}
