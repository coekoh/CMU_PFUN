/**
 * This program is anhelper class for PrintRightTriangle 
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */
public class RightTriangle
{
    private int width;
    private String artMethod;
    private String location;
    
    
    public RightTriangle()
    {
        width = 10;
        artMethod = "*";
        location = "bl";
    }
    
    public RightTriangle(int num, String str, String position)
    {
        width = num;
        artMethod = str;
        location = position;
    }
    
    public void drawAsciiArt()
    {
        if (location.equals("bl"))
        {
            for (int  i = 1; i <= width; i ++)
            {
                System.out.println(buildString(artMethod, i));
            }
        }
        
        if (location.equals("tl"))
        {
            for (int i = width; i >= 1; i--)
            {
                System.out.println(buildString(artMethod, i));
            }
        }
  
        if (location.equals("tr"))
        {
            String space = "";
            while (space.length() < artMethod.length())
            {
                space += " ";
            }
            String reSpace = space;
            int s = space.length();
            for (int i = width; i >= 1; i--)
            {
                System.out.println((space + buildString(artMethod, i)).substring(s));
                space += reSpace;
            }
        }
        
        if (location.equals("br"))
        {
            String space = "";
            while (space.length() < width-1)
            {
                space = space + " ";
            }
            
            String s = space;
            for (int i = 0; i < artMethod.length()-1; i++)
            {
                space += s;
            }
              
            int len = artMethod.length();
            
            for (int  i = 1; i <= width; i ++)
            {
                System.out.println(space  + buildString(artMethod,i));
                if (space.length() != 0)
                {
                   space = space.substring(len); 
                }
            }
        }
    }
    
    private String buildString(String str, int num)
    {
        String result = "";
        
        for (int i = 0; i < num; i++)
        {
            result += str;
        }
        return result;
    }
    
    public int getWidth()
    {
        return width;
    }

    public void setWidth(int num)
    {
        width = num;
    }

    public String getArtMethod()
    {
        return artMethod;
    }

    public void setArtMethod(String str)
    {
        artMethod = str;
    }

    public String getLocation()
    {

        return location;
    }
    
    public String locationWords(String result)
    {
        if (location.equals("tr"))
            result = "Top Right Corner";
        if (location.equals("tl"))
            result = "Top Left Corner";
        if (location.equals("bl"))
            result = "Bottom Left Corner";
        if (location.equals("br"))
            result = "Bottom Right Corner";
        return result;
    }

    public void setLocation(String position)
    {
        location = position;
    }
    
    public String toString()
    {
        String result;
        
        result = "The triangle is of width " + getWidth() + 
                " units. It takes up the string character '" + getArtMethod() + 
                "' and has it's right angle positioned at the " + locationWords(getLocation());
        
        return result;
    }
}
