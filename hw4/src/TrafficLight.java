import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * This program is an helper class for the RunLight Program and represents a traffic light
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

public class TrafficLight extends JPanel
{
    private GraphicalCircle redCircle;
    private GraphicalCircle greenCircle;
    private GraphicalCircle yellowCircle;
    private boolean redIsOn;
    private boolean yellowIsOn;
    private boolean greenIsOn;
    
    public TrafficLight()
    {
        // This is the default constructor
        redCircle = new GraphicalCircle(new Point(150, 250), 100, Color.red);
        yellowCircle = new GraphicalCircle(new Point(150, 350), 100, new Color(0, 100, 0));
        greenCircle = new GraphicalCircle(new Point(150, 450), 100, new Color(187, 187, 0));
        
        redIsOn = true;
        yellowIsOn = false;
        greenIsOn = false;
    }
  
    public void paintComponent(Graphics g)
    {
        // This method paints the entire traffic light
        g.fillRect(100, 150, 100, 400);
        redCircle.paintComponent(g);
        greenCircle.paintComponent(g);
        yellowCircle.paintComponent(g);
    }

    public void change()
    {
        //This method changes the light that goes on when the mouse is pressed
        if (setRedIsOn() == true)
        {
            System.out.println("Green is now On");
            redCircle.setCircleColor(new Color(187, 0, 0) );
            greenCircle.setCircleColor(Color.green);
            yellowCircle.setCircleColor(new Color(187, 187, 0));
        }
        
        else if (setGreenIsOn() == true)
        {
            System.out.println("Yellow is now On");
            greenCircle.setCircleColor(new Color(0, 100, 0));
            yellowCircle.setCircleColor(Color.yellow);
            redCircle.setCircleColor(new Color(187, 0, 0));
        }
        
        else if (setYellowIsOn() == true)
        {
            System.out.println("Red is now On");
            yellowCircle.setCircleColor(new Color(187, 187, 0));
            redCircle.setCircleColor(Color.red);
            greenCircle.setCircleColor(new Color(0, 100, 0));
        }
    }
    
    public boolean setRedIsOn()
    {
        //This method checks if the Red light is on
        if (redCircle.getCircleColor() == Color.red)
            redIsOn = true;
        else
            redIsOn = false;
        return redIsOn;
    }
    
    public boolean setYellowIsOn()
    {
      //This method checks if the Yellow light is on
        if (yellowCircle.getCircleColor() == Color.yellow)
            yellowIsOn = true;
        else
            yellowIsOn = false;
        return yellowIsOn;
    }
    
    public boolean setGreenIsOn()
    {
      //This method checks if the Green light is on
        if (greenCircle.getCircleColor() == Color.green)
            greenIsOn = true;
        else
            greenIsOn = false;
        return greenIsOn;
    }
    
    public String toString()
    {
        String result;
        result = "The trafic Light has 3 circles: " + redCircle  + ", \n" + greenCircle + ", \n" + yellowCircle 
                + ", \nThe red circle(first one) status is set to " + redIsOn + ", \nthe second circle (green) status is set to " + greenIsOn
                + ", \nthe third circle (yellow) status is set to " + yellowIsOn;
        
        return result;
    }


}
