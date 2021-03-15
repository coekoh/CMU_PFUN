import java.util.ArrayList;
import java.util.Random;

/**
 * This program is receives input from command line and adds the content of the file into an array list.
 * New phrases can also be added by the user and the entire array list can be cleared
 *
 * @author Courage Ekoh
 * @author Safari Liberateur
 *
 * Andrew ID: coekoh
 * Andrew ID: sliberat
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class PhraseList
{
    private ArrayList<String> phraseFile = new ArrayList<String>();
    
    
    public PhraseList()
    {
        //This is the default constructor and sets the Phrase File to an empty array list
        phraseFile = new ArrayList<String>();
    }
    
    public PhraseList(String fileName)
    {
        //This constructor takes in a filename and stores the input as an array list
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
            phraseFile.add(inputName);
            inputName = datafile.readString();
        }
        
        datafile.close();
    }
    
    
    public String getRandomPhrase()
    {
        //This method returns string from positions in the array list randomly
        Random r = new Random();
        return phraseFile.get(r.nextInt(phraseFile.size()));
    }
    
    public String getPhrase(int index)
    {
        //This method returns string from indices in the array list by passing in an index
        String phrase;
        if (index < phraseFile.size())
        {
           phrase = phraseFile.get(index); 
        }
        else
        {
            phrase = "Invalid Input, ArrayList has only " + phraseFile.size() + " elements";
        }
        return phrase;
    }
    
    public void addPhrase(String phrase)
    {
        //This method adds phrases to the array list
        phraseFile.add(phrase);
    }
    
    public void print()
    {
        //This method prints out all phrases in the array list
        for (int i = 0; i < phraseFile.size(); i++)
        {
            System.out.println(phraseFile.get(i));
        }
    }
    
    public void clear()
    {
        //This method clears all phrases from the array list
        phraseFile.clear();
    }
    
    public String toString()
    {
        // This is a toString method that tells the size of the array list just to be sure some elements are inserted
        String result;
        result = "The Array List has " + phraseFile.size() + " phrases inserted";
        
        return result;
    }

}
