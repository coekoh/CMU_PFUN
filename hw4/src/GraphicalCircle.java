import java.awt.*;
import javax.swing.JPanel;

/**
 * This program is draws a circle
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

public class GraphicalCircle extends JPanel
{
    private Point circleCentre;
    private int diameter;
    private Color circleColor;
    
    public GraphicalCircle()
    {
        //This is the default constructor
        circleCentre = new Point(150, 250);
        diameter = 100;
        circleColor = Color.black;
    }
    
    public GraphicalCircle(Point centre, int dia, Color c)
    {
        //This is a user defined constructor that takes in three arguments
        circleCentre = centre;
        diameter = dia;
        circleColor = c;
    }
    
    
    public Point getCircleCentre()
    {
        // This is a getter for the circle centre
        return circleCentre;
    }


    public void setCircleCentre(Point centre)
    {
        // This is a setter for the circle centre
        circleCentre = centre;
    }


    public int getDiameter()
    {
        //This is a getter for the circle diameter
        return diameter;
    }


    public void setDiameter(int d)
    {
        //This is a setter for the circle diameter
        diameter = d;
    }


    public Color getCircleColor()
    {
        // This is a getter for the circle color
        return circleColor;
    }


    public void setCircleColor(Color c)
    {
       // This is a setter for the circle color
       circleColor = c;
    }


    public void paintComponent(Graphics g)
    {     
        // This method constructs the circle and fills it using the Graphics package
        super.paintComponent(g);
        g.setColor(circleColor);
        g.fillOval(circleCentre.x - diameter/2, circleCentre.y  - diameter/2, diameter, diameter);
    }
    
    public String toString()
    {
        String result;
        result = "This is a circle with center: " + circleCentre + ", diameter: " + diameter + ", circle color: " + circleColor;
        return result;
    }
}
