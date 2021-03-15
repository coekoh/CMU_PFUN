/**
 * This program is receives a string which it hides and displays an hidden string which can be uncovered by guessing letters
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

public class SecretString
{
  private String secretPhrase;
  private String displayString;
  
  public SecretString()
  {
      //This is the default constructor
      secretPhrase = "Java is Great!";
      displayString = secretPhrase.replaceAll("[a-zA-Z0-9]","_"); 
  }
  
  public SecretString(String secret) 
   {
        //This is the user defined constructor
        secretPhrase = secret;
        displayString = secret.replaceAll("[a-zA-Z0-9]","_"); 
   }
    
    
   public void setPhrase(String secret)
   {
        //This method sets the secret String
        secretPhrase = secret; 
   }
    
   public boolean equals(String phrase)
   {
        //This method checks if the inputed string is same as the secret string
        boolean result;
        if(!phrase.equalsIgnoreCase(secretPhrase))
            result = false;
        else
            result = true;
        
        return result;          
   }
    
   public int reveal(String letters) 
   {      
       int counter = 0;
       String hiddenLetters = "";
       
       for (int i = 0; i < letters.length(); i++)
       {
           for(int j = 0; j < secretPhrase.length(); j++)
           {
               if(String.valueOf(letters.charAt(i)).equalsIgnoreCase(String.valueOf(secretPhrase.charAt(j))))
               {
                   if (j==0)
                   {
                       hiddenLetters = String.valueOf(secretPhrase.charAt(j)) + displayString.substring(j + 1);
                   }
                   else
                   {
                       hiddenLetters = displayString.substring(0, j) + String.valueOf(secretPhrase.charAt(j)) + displayString.substring(j + 1);
                   }
                   counter++;
                   displayString = hiddenLetters;
               }               
           }
          
       }
       
       return counter;
    }
    
    public String toString()
    {
        return displayString;
    }

}
