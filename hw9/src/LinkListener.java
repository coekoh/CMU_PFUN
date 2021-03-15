import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * This program 
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class LinkListener implements HyperlinkListener
{
   private JEditorPane callback;
    
    public LinkListener(JEditorPane _callback)
    {
        callback = _callback;
    }
    public void hyperlinkUpdate(HyperlinkEvent event)
    {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
            try
            {
                System.out.println(event.getURL());
                callback.setPage(event.getURL());
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
                callback.setText("Page not Found");
            }
        }
    }
}
