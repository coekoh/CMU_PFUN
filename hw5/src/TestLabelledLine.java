import java.awt.Point;
import java.io.*;

import javax.swing.JFrame;

public class TestLabelledLine
{
    public static void main(String args[]) throws IOException
    {
        JFrame frame = new JFrame();
        
        LabelledLine hline;
        Point p = new Point(100, 100);
        
        hline = new LabelledLine();
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
