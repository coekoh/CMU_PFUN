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

public class HTMLLink
{
    private String link;
    private String label;
    
    public HTMLLink()
    {
        link = "";
        label = "";
    }
    
    public HTMLLink(String urlLink, String label_)
    {
        link = urlLink;
        label = label_;
    }
    
    public void setLink(String urlLink)
    {
        link = urlLink;
    }
    
    public void setLabel( String label_)
    {
        label = label_;
    }
    
    public String formatLink()
    {
        String htmlLink;
        
        htmlLink = "<a href=" + link + ">" + label + "</a>";
        return htmlLink;
    }
    
    public String getLink()
    {
        return link;
    }

    public String getLabel()
    {
        return label;
    }
    
    public boolean isRelativeLink(HTMLLink object)
    {
        if (!object.getLink().replaceAll("\"", "").startsWith("http"))
            return true;
        return false;
    }

    public String toString()
    {
        return("The link is: " + link + ", the label is: " + label);
    }
}
