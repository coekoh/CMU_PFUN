/**
 * This program represents an elevator which stays in a particular floor at a time and can move between floors
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
public class Elevator
{
    private int currentFloor;
    
    public Elevator()
    {
        //This is the default constructor that sets the current floor to 1
       currentFloor = 1;
    }
    
    public void setCurrentFloor(int floorNum)
    {
        //This is a setter that sets the current floor
        currentFloor = floorNum;
    }
    
    public void moveFloors(int floor)
    {
        // This method decides how the elevator moves based on the floor passed in and moves there
        int i;
        
        Door door = new Door();
        
        if ((floor > currentFloor) && (floor <= 20))
        {
            door.changeDoorStatus(currentFloor);
            for (i = 1; i < floor - currentFloor; i++)
            {
                System.out.println("Going up to floor " + (currentFloor + i));
            }
            currentFloor = currentFloor + i;
            door.changeDoorStatus(currentFloor);
            
        }
        
        else if ((floor < currentFloor) && (floor >= 1))
        {
            door.changeDoorStatus(currentFloor);
            for (i = currentFloor-1; i > floor; i--)
            {
                System.out.println("Going down to floor " + (i));
                currentFloor--;
            }
            
            currentFloor = i;
            door.changeDoorStatus(currentFloor);
        }
             
        else if (floor == currentFloor)
        {
            door.changeDoorStatus(currentFloor);
            door.changeDoorStatus(currentFloor);
        }
        
        else
        {
            System.out.println("Invalid floor!");
        }
     }
    
    public String toString()
    {
        String result;
        result = "The elevator is on floor " + currentFloor;
        return result;
    }

}
