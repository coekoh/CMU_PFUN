import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

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

public class Exceptions
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
        String str;
        
        
//        http://public.africa.cmu.edu/cbishop/pfun/OH2020.html
        
//        bigboy.com
        
//        https://google3.com
        
        
        System.out.println("Please enter a url");
        str = keyboard.readLine();
                    
        while(!str.equals(""))
        {
            System.out.println("Loop 1");
            
            stackTrace(str);
            System.out.println("Please enter a url");
            str = keyboard.readLine();
        }
        
        System.out.println("Please enter a url");
        str = keyboard.readLine();
        
        while(!str.equals(""))
        {
            System.out.println("Loop 2");

            exceptionToString(str);
            System.out.println("Please enter a url");
            str = keyboard.readLine();
        }
        
        System.out.println("Please enter a url");
        str = keyboard.readLine();
        
        while(!str.equals(""))
        {
            System.out.println("Loop 3");

            exceptionMessage(str);
            System.out.println("Please enter a url");
            str = keyboard.readLine();
        }

        
    }
    
    public static void stackTrace(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            url.getContent();
        }
        
        catch (IOException e)
        {
            e.printStackTrace();;
        }
        
        
    }
    
    public static void exceptionToString(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            url.getContent();
        } 
        
        catch (IOException e)
        {
            System.out.println(e.toString());
        }


    }
    
    public static void exceptionMessage(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            url.getContent();
        } 
        
        catch (FileNotFoundException e)
        {
            System.out.println( urlString + " Not Found");
        }
        catch (MalformedURLException e)
        {
            System.out.println(urlString + " has a MalformedURL Exception");;
        }
        
        catch (IOException e)
        {
            System.out.println(urlString + " has an IOException");
        }

        

    }
  
    


}
