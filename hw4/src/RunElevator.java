import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program runs an elevator system with user inputs
 *
 * @author Courage Ekoh
 * @author Safari Liberateur
 *
 * Andrew ID: coekoh
 * Andrew ID: sliberat
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class RunElevator
{
    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
        String str;
        int floor;
        
        Elevator elevator = new Elevator();
        System.out.println(elevator);
        
        System.out.print("\nPlease enter the new floor (Enter to quit): ");
        str = keyboard.readLine();
        
        while (!str.equals(""))
        {
            floor = Integer.parseInt(str);
            
            elevator.moveFloors(floor);
            System.out.println("\n" + elevator);
            
            System.out.print("\nPlease enter the new floor (Enter to quit): ");
            str = keyboard.readLine();
            
        }
        
        System.out.println("\nBye!");

    }

}
