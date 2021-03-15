/**
 * This program takes in strings from user input and then breaks it into letters, words and sentences
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
import java.io.*;
import java.util.*;


public class ConnectTheDots extends JPanel
{
    private Point dots[];
    private int numDots = 0;
    
    public ConnectTheDots(Point pointList[], int n)
    {
        dots = pointList;
        numDots = n;
    }
    
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
    
        g.setColor(Color.black);
    
    
        /*
         * YOU WRITE THE CODE!
         *
         * Use a loop to process each Point in the the dots array. Your processing will be
         * to connect them.
         *
         *  Note: the dots array is declared above - use it, do NOT declare another one.
         *  Hint: what variable, declared above represents the number of dots?? Use it!
         *
         * Your call inside the loop will be something like the line below, but it must use
         * the loop instead of hardcoding 0 and 1.
         *
         * Note: make sure when your loop is finished that you connect the last dot to the first.
         *
         */
        for (int i = 0; i < numDots-1; i++)
        {
            connect(g, dots[i], dots[i+1]);
            
        }
        connect(g, dots[numDots-1], dots[0]);
    
    }
    
    public void connect(Graphics g, Point p1, Point p2)
    {
        // Connect the points by drawing a line from p1 to p2
        int x1, y1;
        int x2, y2;
    
        // YOU WRITE THE CODE
    
        x1 = p1.x;
        y1 = p1.y;
        x2 = p2.x;
        y2 = p2.y; 
    
        // Note: this is a trace statement
        System.out.print("(" + x1 + ", " + y1 + ")");
        System.out.print("-->");
        System.out.print("(" + x2 + ", " + y2 + ")");
        System.out.println();
        
        // YOU WRITE THE CODE
        // Write the code to draw a line from x1,y1 to x2,y2 (using g)
        g.drawLine(x1, y1, x2, y2);
    }
    
    public static void main(String argv[]) throws IOException
    {
        JFrame frame = new JFrame();
    
        // YOU WRITE THE CODE!
        BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
        String coords[];
        Point points[];
        points = new Point[25];
    
        int numPoints = 0;  // Note: what does this variable represent?
        String str;
        int x, y;
    
        // Note: this loop matches the standard structure of a loop that gets input.
    
        System.out.print("Enter point " + (numPoints + 1) + " in x,y format: ");
        str = keyboard.readLine();
        while (!str.equals(""))
        {
            // YOU WRITE THE CODE!            
            coords = str.split("[,\\s]+");            
            x = Integer.parseInt(coords[0]);
            y = Integer.parseInt(coords[1]);
            
            points[numPoints] = new Point(x,y);
            numPoints++;
            
            if(numPoints == points.length)
                break;
    
            System.out.print("Enter point " + (numPoints + 1) + " in x,y format: ");
            str = keyboard.readLine();
        }
    
        printArray("Dots", points, numPoints);
    
        System.out.println("Now I will connect your " + numPoints + " dots");
        ConnectTheDots art = new ConnectTheDots(points, numPoints);
    
        frame.add(art);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setVisible(true);
    }
    
    public static void printArray(String label, Object array[])
    {
        printArray(label, array, array.length);
    }
    
    public static void printArray(String label, Object array[], int n)
    {
        // YOU WRITE THE CODE!
        // This is modeled after the printArray() method you wrote for WordCount
        for (int i = 0; i < n; i++)
        {
            System.out.println(label + "[" +i + "]: " + array[i]);
        }
    }

}