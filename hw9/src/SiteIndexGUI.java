import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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

public class SiteIndexGUI extends LayoutGUI
{
    private IndexGenerator generatorObject = new IndexGenerator();
    private JTextField  enteredURL;
    private JEditorPane textPane, examplePane;
    private WebCrawler crawler;
    private String exampleFile = generatorObject.getExamplesHTMLFile();
    private String termsFile = generatorObject.getWordsIndexFile();
    private String url;

    
    public void addComponents(JFrame theFrame)
    {
        JButton generateButton, returnToTerms, returnToExample;
        JScrollPane textScroll, exampleScroll;
        
        enteredURL = new JTextField("http://public.africa.cmu.edu/cbishop/pfun/");

        
        generateButton = new JButton("Generate");
        generateButton.addActionListener(new GenerateListener());
   
        returnToTerms = new JButton("Return to Terms List");
        returnToExample = new JButton("Return to Examples List");
     
        
        
        textPane = new JEditorPane();
        textPane.setPreferredSize(new Dimension(500, 800));
        textPane.setEditable(false);
        returnToTerms.addActionListener(new ReturnListener(textPane, termsFile));
        
        examplePane = new JEditorPane();
        examplePane.setPreferredSize(new Dimension(500, 800));
        examplePane.setEditable(false);
        returnToExample.addActionListener(new ReturnListener(examplePane, exampleFile));
        
        textScroll = new JScrollPane(textPane);
        exampleScroll = new JScrollPane(examplePane);
        textPane.addHyperlinkListener(new LinkListener(textPane));
        examplePane.addHyperlinkListener(new LinkListener(examplePane));
               
        
        Container c =  theFrame.getContentPane();
        c.setLayout(new BorderLayout());
        
        JPanel Buttons = new JPanel();
        Buttons.setLayout(new FlowLayout());
        
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1,2));
        pane.add(textScroll);
        pane.add(exampleScroll);
        
        
        Buttons.add(enteredURL);
        Buttons.add(generateButton);
        Buttons.add(returnToTerms);
        Buttons.add(returnToExample);
        
        c.add(Buttons, BorderLayout.NORTH);
        c.add(pane, BorderLayout.CENTER);
        
    }
    
    public void crawlSite() throws IOException
    {
        HTMLLink linkObject = new HTMLLink(url, "PFUN Website");
        crawler = new WebCrawler("PFUN Website", url);     
        crawler.readTerms("terms.txt");
        crawler.crawl(linkObject);
        crawler.crawl();
        crawler.writeFiles("04-330");
        display(examplePane, exampleFile);
        display(textPane, termsFile);
    }
    
    public void display(JEditorPane pane, String filename) throws IOException
    {
        try
        {
            URL url = new File(filename).toURI().toURL();
            pane.setPage(url);
        } 
        
        catch (MalformedURLException e)
        {
            
            System.out.println("Unable to Access site");
        }
    }
    
    class ReturnListener implements  ActionListener
    {
        private JEditorPane editorPane;
        private String filename;
        
        public ReturnListener(JEditorPane pane, String file)
        {
            editorPane = pane;
            filename = file;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            try
            {
                display(editorPane, filename);
            }
            
            catch (IOException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
        }
    }
    
    class GenerateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                url = enteredURL.getText();
                
                if (url.isEmpty())
                {
                    url = "http://public.africa.cmu.edu/cbishop/pfun/";
                }
                
                crawlSite();
            }
            
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

}
