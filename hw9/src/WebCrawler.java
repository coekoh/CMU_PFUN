import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

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
public class WebCrawler
{
    private ArrayList<HTMLLink> waitingLinks = new ArrayList<HTMLLink>();
    private ArrayList<HTMLLink> processedLinks = new ArrayList<HTMLLink>();
    private ArrayList<HTMLLink> exampleFiles = new ArrayList<HTMLLink>();
    private HashMap<String, ArrayList<HTMLLink>> termLists = new HashMap<String, ArrayList<HTMLLink>>();
    private HTMLLink url;
    
    public WebCrawler(String label, String link)
    {
        url = new HTMLLink(label, link);
    }
  
    public ArrayList<String> readInURL(String webLink) throws MalformedURLException, IOException
    {        
        ArrayList<String> URLLines = new ArrayList<String>();
        BufferedReader webPage = new BufferedReader(new InputStreamReader(new URL(webLink).openStream()));
        String str = webPage.readLine();
        
        while (!str.equals(""))
        {
            URLLines.add(str);
        }
        
        webPage.close();
        
        return URLLines;       

    }
    
    public void readTerms(String fileName)
    {
        String inputName;
        InputDataFile   datafile;
        datafile = new InputDataFile(fileName);
        datafile.open();
        
        if (!datafile.isOpen())
        {
            System.out.println("Cannot open " + datafile.getName() + " for reading. Program ending. ");
            System.exit(1);
        }
        
        inputName = datafile.readString();
        while (inputName != null)
        { 
            termLists.put(inputName, new ArrayList<HTMLLink>());
            inputName = datafile.readString();
        }
        
        datafile.close(); 
    }
    
    public void addLinkToList(HTMLLink link)
    {
        if(URLUtils.isExampleFile(link) && !(URLUtils.isLinkOnList(link.getLink(), exampleFiles)))
        {
                exampleFiles.add(link);
                return;
                
        }
        else if (URLUtils.isLinkOnList(link.getLink(), waitingLinks))
        {
            
                return;
        }
        
        else if (URLUtils.isLinkOnList(link.getLink(), processedLinks))
        {
            
                return;
        }
        
        else
        {
            waitingLinks.add(link);
        }
    }
    
    public void crawl(HTMLLink link) throws IOException
    {
        
        String strippedHTML, s;
        s = link.getLink();
        
        if (s.contains("http") && !s.contains("pfun"))
            return;
        if(s.contains("#"))
                return;
    
        if (!s.contains("http"))
        {
            
            s =  "http://public.africa.cmu.edu/cbishop/pfun/" + s;
        }
        
        if (!URLUtils.urlIsValid(s))
        {
            return;
        }

        URL pageSite = new URL(s);
        BufferedReader webPage = new BufferedReader(new InputStreamReader(pageSite.openStream()));
        String str = webPage.readLine();
            
        
        while(str != null)
        {
            strippedHTML =URLUtils.stripHTML(str);
            
            for (String term: termLists.keySet())
            {
                ArrayList<HTMLLink> linkObject;
                
                linkObject = termLists.get(term);
                
                if((URLUtils.containsTerms(strippedHTML, term)) && (!linkObject.contains(link)))
                {
                    linkObject.add(link);
                    termLists.replace(term, linkObject);
                }
            }
            
            
            
            if (URLUtils.hasLink(str))
            {
                HTMLLink htmlLink = URLUtils.getLink(str);
                if (htmlLink != null)
                    addLinkToList(htmlLink); 
            }
            
            
            str = webPage.readLine();   
         
        }


    }
    
    public void crawl() throws IOException
    {
        while(!waitingLinks.isEmpty())
        {
            HTMLLink link = waitingLinks.get(0);
            waitingLinks.remove(link);
            processedLinks.add(link);  
            crawl(link);
            
        }
    }
    
    
    public void writeFiles(String filename)
    {
        String termsHtmlFile;
        String examplesHtmlFile;
        String termsString;
        String examplesString;
        
        termsHtmlFile = filename + "_TermsFile.html";
        examplesHtmlFile = filename +"_ExamplesFile.html";
        
        OutputDataFile outputExampleFile = new OutputDataFile(examplesHtmlFile);
        outputExampleFile.open();
        
        if (!outputExampleFile.isOpen())
        {
            System.out.println("Cannot open " + outputExampleFile.getName() + " for reading. Program ending. ");
            System.exit(1);
        }
        
        examplesString = "<html>\r\n"
                + "<base href=http://public.africa.cmu.edu/cbishop/pfun/ target=\"_blank\">\r\n"
                + "<title>Your program Writes The Title</title>";
        
        for (HTMLLink link: exampleFiles)
        {
            examplesString += "<p>" + link.formatLink();
        }
        
        outputExampleFile.println(examplesString);
        outputExampleFile.close();
        
        OutputDataFile outputTermsFile = new OutputDataFile(termsHtmlFile);
        outputTermsFile.open();
        termsString = "<html>\r\n"
                + "<base href=http://public.africa.cmu.edu/cbishop/pfun/ target=\"_blank\">\r\n"
                + "<title>Your program Writes The Title</title>";
        
        if (!outputTermsFile.isOpen())
        {
            System.out.println("Cannot open " + outputTermsFile.getName() + " for reading. Program ending. ");
            System.exit(1);
        }
        
        ArrayList<HTMLLink> links;
        for (String term : termLists.keySet())
        {
            termsString += "<p><b>" + term + "</b>\n:"; 
            links = termLists.get(term);
            
            for (HTMLLink link: links)
            {
                termsString += "<p>" + link.formatLink();
            }
            
        }
  
        outputTermsFile.println(termsString);
        outputTermsFile.close();
        
    }
    
    public String toString()
    {
        return "WebCrawler [toProcessHTML=" + waitingLinks+ ", processedLinks=" + processedLinks + "]";
    }
}
