/**
 * This class draws lines from each of the four corners of a square
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

import java.awt.*;
import javax.swing.*;

// Note: no comments on purpose

public class LineArt extends JPanel
{
    // declare the private instance variables
    
    private int numLines = 0;
    private int width;
    private int height; 
    
    public LineArt(int n)           
    { 
        numLines = n; 
    }
    public void setNumLines(int n)  
    { 
        numLines = n; 
    }
    public int  getNumLines()       
    { 
        return numLines; 
    }
    
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
    
        // Note: why do we get the width and height everytime in paintComponent?
    
        width  = getWidth();
        height = getHeight();
    
        int widthStep = width / (numLines - 1);
        int heightStep = height / (numLines - 1);
        g.setColor(Color.blue);
    
        // Call the paintHalfLines() method so it draws from the top-left corner
        paintHalfLines(g, 0, 0, widthStep,heightStep); 
        paintHalfLines(g, 0, height, widthStep,heightStep);
        paintHalfLines(g, width, 0, widthStep,heightStep);
        paintHalfLines(g, width, height, widthStep,heightStep);
    }
    
    public void paintHalfLines(Graphics g, int startX, int startY, int widthStep, int heightStep)
    {
        // declare the needed local variables here.
        int endX;
        int endY;
        int i;
    
        Point p = findEndPoint(startX, startY);
    
        endX = p.x;
        endY = p.y;
    
        
        if (isBottomRight(startX, startY))
        {
            heightStep *= 1;
            widthStep *= -1;
        }
        
        if (isTopLeft(startX, startY))
        {
            heightStep *= 1;
            widthStep *= -1;
        }
        
        if (isBottomLeft(startX, startY))
        {
            heightStep *= 1;
            widthStep *= 1;
        }
        
        if (isTopRight(startX, startY))
        {
            heightStep *= 1;
            widthStep *= 1;
        }
                
                
    
        for (i = 0; i <= numLines; i++)
        {
            System.out.println("Line: " + (i + 1) + " (" + startX + "," + startY + ") -- ("
        + endX + ", " + endY + ")");
    
            // add the code to draw the line here
            
            g.drawLine(startX, startY, endX, endY);    
            endX += widthStep;
            endY += heightStep;
        }
    }
    public Point findEndPoint(int x, int y)
    {
        if (isBottomLeft(x, y) || isTopRight(x, y))
            return new Point(0, 0);
        
        return (new Point (width, 0));
    }
    
    public boolean isTopLeft(int x, int y)
    {
        // Write this code
        if (x == 0 && y == 0)
            return true;
        return false;
    }
    
    public boolean isBottomLeft(int x, int y)
    {
        // Write this code
        if (x == 0 && y == height)
            return true;    
        return false;
    }
    
    public boolean isTopRight(int x, int y)
    {
        // Write this code
        if (x == width && y == 0)
            return true;    
        return false;
    }
    
    public boolean isBottomRight(int x, int y)
    {
        // Write this code
        if (x == width && y == height)
            return true;    
        return false;
    }
    
    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        LineArt art = new LineArt(10);

        frame.add(art);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 272); // Note, not 250 * 250 because of JFrame header size (along the top)
        frame.setVisible(true);
    }
}