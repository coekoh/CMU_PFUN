public class ReadIn
{
    public static void main (String args[])
    {
        InputDataFile   datafile;
        String          filename;
        
        String          names[] = new String[5];
        String          inputName;
        int             numNames = 0;
        
        int             i = 0;
        
//        if (args.length == 0)
//            filename = "names.txt";
//        else
            filename = "C:\\Users\\Courage Ekoh\\eclipse-workspace\\hw4\\bin\\names.txt";
        
        datafile = new InputDataFile(filename);
        
        datafile.open();
        
        if (!datafile.isOpen())
        {
            System.out.println("Cannot open " + datafile.getName() + " for reading. Program ending. ");
            System.exit(1);
        }
        
        inputName = datafile.readString();
        while (inputName != null)
        {
            if (numNames >= names.length)
            {
                System.err.println("Sorry, this program can only accept up to " + names.length + " names.");
                break;
            }
            
            names[i] = new String(inputName);
            i++;
            numNames++;
            System.out.println("Trace message - processed " + inputName + " added it.");
            inputName = datafile.readString();
        }
        
        datafile.close();
        
        System.out.println();
        System.out.println("I read in " + numNames + " names from " + filename + ".");
        System.out.println();
        i = 1;
        for (String name : names)
        {
           System.out.println("Name " + i + ": " + name); 
           i++;
        }
    }
}
