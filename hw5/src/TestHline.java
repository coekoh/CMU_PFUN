import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class TestHline
{
    
    public static void main(String args[]) throws IOException
    {
        JFrame frame = new JFrame();
        
        Line hline;
        Point p = new Point(100, 100);
        
        hline = new Line();
        hline.setHorizontal();
        hline.setThickness(50);
        hline.setLength(100);
        hline.setStartPoint(p);
        hline.setDebug();
        System.out.println(hline);
        
        frame.add(hline);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setVisible(true);
    }

}
