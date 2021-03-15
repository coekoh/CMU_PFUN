import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program converts a very large binary number to hex
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class HexFun
{

    public static void main(String[] args) throws IOException
    {
        String binaryNum;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Please enter a binary number: ");
        binaryNum = input.readLine();
        while (binaryNum.length() % 4 != 0)
        {
            binaryNum = "0" + binaryNum;
        }
        if (convertToHex(binaryNum).contains("null"))
        {
            System.out.println("\nYour input is not a binary Number, Bye for now");
        }
        else
        {
            System.out.println("\nThe binary number " + binaryNum + " is " + convertToHex(binaryNum) + " in hex");
        }
    }
    
    public static String convertToHex(String binaryNumber)
    {
        String result; String sub;
        result = "0x";
        
        for (int i = 0; i < binaryNumber.length(); i+=4)
        {
            sub = binaryNumber.substring(i, i+4);
            result += convertHexDigit(sub);
        }
        
        return result;
    }
    
    public static String convertHexDigit(String binaryNumber)
    {
        String result = null;
        
        if (binaryNumber.equals("0000"))
            result = "0";
        if (binaryNumber.equals("0001"))
            result = "1";
        if (binaryNumber.equals("0010"))
            result = "2";
        if (binaryNumber.equals("0011"))
            result = "3";
        if (binaryNumber.equals("0100"))
            result = "4";
        if (binaryNumber.equals("0101"))
            result = "5";
        if (binaryNumber.equals("0110"))
            result = "6";
        if (binaryNumber.equals("0111"))
            result = "7";
        if (binaryNumber.equals("1000"))
            result = "8";
        if (binaryNumber.equals("1001"))
            result = "9";
        if (binaryNumber.equals("1010"))
            result = "A";
        if (binaryNumber.equals("1011"))
            result = "B";
        if (binaryNumber.equals("1100"))
            result = "C";
        if (binaryNumber.equals("1101"))
            result = "D";
        if (binaryNumber.equals("1110"))
            result = "E";
        if (binaryNumber.equals("1111"))
            result = "F";
        
        return result;
    }

}
