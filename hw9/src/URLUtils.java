import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

public class URLUtils
{
    public static String getBaseURL(String url) throws MalformedURLException
    {
        URL baseURL = new URL(url);

        return baseURL.getHost();
    }

    public static boolean hasLink(String line)
    {
        if (line.contains("href"))
            return true;
        else
            return false;
    }

    public static HTMLLink getLink(String link)
    {
        HTMLLink linkObject;
        String htmlLink, label;
        int startIndex;
        int endIndex;
        int labelStartIndex, labelEndIndex;

        try
        {
            if (link.contains("href"))
            {
                startIndex = link.indexOf("=");
                endIndex = link.indexOf(">", startIndex);
                htmlLink = link.substring(startIndex + 1, endIndex);

                if (link.substring(endIndex + 1, endIndex + 2).equals("b"))
                {
                    labelStartIndex = link.indexOf(">", endIndex);
                    labelEndIndex = link.indexOf("<", labelStartIndex);
                }
                
                else
                {
                    labelStartIndex = endIndex;
                    labelEndIndex = link.indexOf("<", labelStartIndex);
                }

                label = link.substring(labelStartIndex + 1, labelEndIndex);
                htmlLink = htmlLink.replaceAll("[\"\"\'\']", "");

                linkObject = new HTMLLink(htmlLink, label);
                return linkObject;
            } 
            
            else
                return null;
        }

        catch (Exception e)
        {
            return null;
        }
    }

    public static boolean isLinkOnList(String s, ArrayList<HTMLLink> list)
    {
        for (HTMLLink link : list)
        {
            if (link.getLink().equalsIgnoreCase(s))
                return true;
        }

        return false;
    }

    public static boolean isExampleFile(HTMLLink htmlLink)
    {
        if (htmlLink == null)
        {
            return false;
        }
        String link = htmlLink.getLink();

        if (link.endsWith(".java") || link.endsWith(".cpp") || link.endsWith(".c") || link.endsWith(".h"))
        {
            return true;
        } 
        else
            return false;
    }

    public static boolean isExampleFile(String link)
    {
        if (link.endsWith(".java") || link.endsWith(".cpp") || link.endsWith(".c") || link.endsWith(".h"))
        {
            return true;
        }

        else
            return false;
    }

    public static String stripHTML(String htmlLink)
    {
        return htmlLink.replaceAll("\\<.*?>", "").toLowerCase();
    }

    public static boolean containsTerms(String line, String terms)
    {
        if (line.toLowerCase().contains(terms.toLowerCase()))
            return true;
        else
            return false;
    }

    public static boolean isLinkOnList(HTMLLink link, ArrayList<HTMLLink> listOfLinks)
    {

        return listOfLinks.contains(link);
    }

    public static boolean urlIsValid(String url)
    {
        try
        {
            URL urlServer = new URL(url);
            HttpURLConnection urlConn = (HttpURLConnection) urlServer.openConnection();
            urlConn.setConnectTimeout(3000); // <- 3Seconds Timeout
            urlConn.connect();

            if (urlConn.getResponseCode() == 200)
            {
                return true;
            }

            else
            {
                return false;
            }

        }

        catch (IOException e)
        {
            return false;
        }
    }
}
