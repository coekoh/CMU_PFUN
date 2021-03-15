import java.io.*;
import java.util.*;

/**
 * This program represents
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class MadDictionary implements Serializable
{
    private HashMap<String, StringBuffer> madWords;
    
    public MadDictionary()
    {
        madWords = new HashMap<String, StringBuffer>();
    }
    
    public StringBuffer addWord(String word, StringBuffer description)
    {
        if (getDescription(word) != null)
            return null;
        
        //------- You write the code ------
        // Call the method to add the key (word) and the value (description) to madWords
        madWords.put(word.toLowerCase(), description);
        
        return description;
    }
    
    public StringBuffer getDescription(String word)
    {
        StringBuffer description;
        
      //------- You write the code ------
      // Call the method to set  description to the value in madWords, for the key word
        description = madWords.get(word.toLowerCase());
             
        return description;        
    }
    
    public void print()
    {
        for (String key : madWords.keySet())
        {
          //------- You write the code ------
          // Write the System.out.println() call to print the key and value in madWords
          
          System.out.println("Word is: " + key + " , Discription is: " + madWords.get(key));
            
            
        }
    }
    
    public String toString()
    {
        return ("The Mad Dictionary has " + madWords.size() + " words");
    }

}
