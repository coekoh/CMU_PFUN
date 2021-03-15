import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * This program runs SiteIndexGUI 
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class SiteIndex extends JComponent
{
    public static void main(String[] args)
    {
        final LayoutGUI gui;
         gui = new SiteIndexGUI();
         
         javax.swing.SwingUtilities.invokeLater(new Runnable()
         {
             public void run()
             {
                 createAndShowGUI(gui);
             }
         }); 
    }
    
    private static void createAndShowGUI(LayoutGUI gui)
    {
        // Create a JFrame and get its content pane
    
        JFrame      theFrame = new JFrame(gui.getClass().getName() + " Application");
        Container   c = theFrame.getContentPane();
    
    
        // Tell the GUI to add its components to the frame
    
        gui.addComponents(theFrame);
    
        // Set the size of the frame and exit behavior
    
        theFrame.setPreferredSize(new Dimension(700, 700));
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // show the frame
    
        theFrame.pack();
        theFrame.setVisible(true);
    }
}
