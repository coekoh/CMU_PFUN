import java.io.*;

public class Bad2
{
public static void main (String args[]) throws IOException
{

    BufferedReader keyboard =
         new BufferedReader(new InputStreamReader(System.in));

    String   str = "";
    int num1;
    int num2;

    System.out.print("Enter a number: ");
    str = keyboard.readLine();
    num1 = Integer.parseInt(str);

    System.out.print("Enter another number: ");
    str = keyboard.readLine();
    num2 = Integer.parseInt(str);

    System.out.println("The sum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
}
}
