import java.io.*;

public class Bad1
{
public static void main (String args[]) throws IOException
{

    BufferedReader keyboard =
         new BufferedReader(new InputStreamReader(System.in));

    String   str = "";
    int num1;
    boolean entered10 = false;

    System.out.print("Enter a number: ");
    str = keyboard.readLine();
    num1 = Integer.parseInt(str);

    if (num1 == 10)
        entered10 = true;

    if (entered10 == true)
        System.out.println("You entered 10");
    else
        System.out.println("You did not enter 10");
}
}
