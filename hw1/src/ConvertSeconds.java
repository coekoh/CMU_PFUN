/**
 * This program breaks down total number of seconds to hours, minutes and seconds
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

import java.io.*;

public class ConvertSeconds
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the total number of seconds to convert");
        String str1 = input.readLine();
        int numSeconds = Integer.parseInt(str1);
        int hours = numSeconds / 3600;
        int minutes = (numSeconds % 3600) / 60;
        int seconds = (numSeconds % 3600) % 60;
        System.out.println("\n****  Output  ****\n");
        System.out.println("Hours: " + hours +
                "\nMinutes: " + minutes + 
                "\nSeconds: " + seconds);
        

    }

}
