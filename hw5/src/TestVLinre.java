import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class TestVLinre
{
    
    public static void main(String args[]) throws IOException
    {
        JFrame frame = new JFrame();
        
        Line vline;
        Point p = new Point(100, 100);
        
        vline = new Line();
        vline.setVertical();
        vline.setThickness(50);
        vline.setLength(100);
        vline.setStartPoint(p);
        vline.setDebug();
        
        frame.add(vline);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setVisible(true);
    }

}
