import java.io.*;
/**
 * This class takes a 9-character string representing 
 * Linux file permissions, and prints the value that the 
 * chmod command would use to properly set the permissions
 * 
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class LinuxPermissions
{

    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a 9-character string representing Linux file permissions:");
        String str = input.readLine();
        if (str.length() != 9 || permissionString(str) == "" || permissionString(str).length() < 3)
            System.out.println("Entry not valid, please check properly and enter a valid Linux Permission");
        else
            System.out.println("The value that the chmod command would use to properly set the permissions is:\n"
                + permissionString(str));
    }
    
    public static String permissionString(String perms)
    {
        String sub1 = perms.substring(0,3);
        String sub2 = perms.substring(3,6);
        String sub3 = perms.substring(6);
        
        String result = onePermission(sub1) + onePermission(sub2) +
                onePermission(sub3);
        
        return result;
    }

    public static String onePermission(String perms)
    {
        String result = "";
        if (perms.equals("---"))
            result = "0";
        
        else if (perms.equals("--x"))
            result = "1";
        
        else if (perms.equals("-w-"))
            result = "2";
        
        else if (perms.equals("-wx"))
            result = "3";
            
        else if (perms.equals("r--"))
            result = "4"; 
            
        else if (perms.equals("r-x"))
            result = "5";
            
        else if (perms.equals("rw-"))
            result = "6";
        
        else if (perms.equals("rwx"))
            result = "7";
        
        return result;
      
    }
    
    
}
