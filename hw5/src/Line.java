import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Line extends JPanel
{
    
    
    private LineDirection type;
    private int thickness;
    private int length;
    private Point startPoint;
    private boolean debug = false;
    
    public Line()
    {
        type = LineDirection.VERTICAL;
        thickness = 1;
        length = 1;
        startPoint = new Point(1, 1);
    }
    
    public Line (LineDirection dir)
    {
        type = dir;
        thickness = 1;
        length = 1;
        startPoint = new Point(1, 1);
    }

    public int getThickness()
    {
        return thickness;
    }

    public void setThickness(int newT)
    {
        thickness = newT;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int newL)
    {
        length = newL;
    }

    public Point getStartPoint()
    {
        return startPoint;
    }

    public void setStartPoint(Point p)
    {
        startPoint = p;
    }
    
    public boolean isHorizontal()
    {
       return type == LineDirection.HORIZONTAL;
    }
    
    public boolean isVertical()
    {
        return type == LineDirection.VERTICAL;
    }
    
    public void setHorizontal()
    {
        type = LineDirection.HORIZONTAL;
    }
    
    public void setVertical()
    {
        type = LineDirection.VERTICAL;
    }
    
    public void setDebug()
    {
        debug = true;
    }
    
    public void clearDebug()
    {
        debug = false;
    }
    
    public String toString()
    {
        String str = "";
        
        str += type + " line. ";
        str += "Thickness: " + thickness + " Length: " + length;
        str += " (in pixels) ";
        str += "Starts at: " + startPoint + ". ";
        
        return str;
    }

    public void paintComponent(Graphics g)
    {
        int startX;
        int startY;
        int width;
        int height;
        int testLineX2;
        int testLineY2;
        
        int midX = (int)startPoint.getX();
        int midY = (int)startPoint.getY();
        
        if (isHorizontal())
        {
            startX = midX;
            startY = midY - (thickness/2);
            width = length;
            height = thickness;
            
            testLineX2 =  midX + length;
            testLineY2 = midY;
        }
        
        else //is vertical
        {
            startX = midX - (thickness/2);
            startY = midY;
            width = thickness;
            height = length;
            
            testLineX2 =midX;
            testLineY2 = midY + length;
        }
        
        g.fillRect(startX, startY, width, height);
        if (!debug)
            return;
        g.setColor(Color.RED);
        g.drawLine(midX, midY,testLineX2, testLineY2);
    }
}
