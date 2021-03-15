/**
 * This program represents a door which can open or close
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

public class Door
{
    private boolean doorIsOpen;
    
    public Door()
    {
        // This is the default constructor that sets door to open
        doorIsOpen = true;       
    }

    public boolean isDoorIsOpen()
    {
        //This is a getter for the door state
        return doorIsOpen;
    }

    public void setDoorIsOpen()
    {
        //This is a setter for the state of the door
        doorIsOpen = true;
    }
    
    public void changeDoorStatus(int floor)
    {
        //This method changes the door status from open to close and vice versa
        if (doorIsOpen == true)
        {
            doorIsOpen = false;
            System.out.println("\nCloosing door.");
        }
        
        else if (doorIsOpen == false)
        {
            doorIsOpen = true;
            System.out.print("Opening door at floor " + floor + ".\n");
        }
    }
    
    public String toString()
    {
        String result;
        result = "The door state of being open is set to " + doorIsOpen;
        
        return result;
    }

}
