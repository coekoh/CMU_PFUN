import java.net.MalformedURLException;

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

public class IndexGenerator
{
    private String startingURL;
    private String baseURL;
    private String webPageTitle;
    private String wordsIndexFile;
    private String examplesIndexFile;
    
    public IndexGenerator()
    {
        startingURL = "";
        webPageTitle = "04-330";
    }
    
    public IndexGenerator(String startUrl)
    {
        startingURL = startUrl;
    }

    public void setStartingURL(String startUrl)
    {
        startingURL = startUrl;
    }
    
    public String getStartingURL()
    {
        return startingURL;
    }
    
    public String getBaseURL() throws MalformedURLException
    {       
        baseURL = URLUtils.getBaseURL(startingURL);
        
        return baseURL;
    }
    
    public String getWebPageTitle()
    {        
        return webPageTitle;
    }
    
    public String getWordsIndexFile()
    {
        wordsIndexFile = getWebPageTitle() + "_TermsFile.html";
        
        return wordsIndexFile;
    }
    
    public String getExamplesHTMLFile()
    {
        examplesIndexFile = getWebPageTitle() + "_ExamplesFile.html";
        
        return examplesIndexFile;
    }

    public String toString()
    {
        String result =
        null;
        try
        {
            result =  "URL: " + getBaseURL() + "    wordsIndexFile: " + getWordsIndexFile() + "  examplesIndexFile: " + getExamplesHTMLFile();
        } 
        
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    
    
    
}
