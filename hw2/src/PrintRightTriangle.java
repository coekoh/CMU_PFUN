import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program prompts a user for 3 values that define a right triangle and then prints the 
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
public class PrintRightTriangle
{

    public static void main(String[] args) throws IOException
    {
        String widthInput; int num; String str; String position;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Kindly enter the width of the triangle you intend to create");
        widthInput = input.readLine();
        
        while (!widthInput.equals(""))
        {
            num = Integer.parseInt(widthInput);
            
            System.out.println("Kindly enter the string type you wish in constructing your triangle");
            str = input.readLine();
            
            System.out.println("Enter the position of right angle in the triangle. i.e tl, bl, tr, br");
            position = input.readLine();
            
            RightTriangle r = new RightTriangle (num, str, position);
            System.out.println("\n" + r);
            r.drawAsciiArt(); 
            
            System.out.println("Kindly enter the width of another triangle you intend to create");
            widthInput = input.readLine();
        }
        
        System.out.println("End of Program!");
    }
}
