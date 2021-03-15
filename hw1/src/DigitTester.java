/**
 * This class tests methods that manipulate digits in integer numbers.
 *
 * @author Courage Ekoh
 *
 * Andrew ID: coekoh
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work
 *
 */

public class DigitTester
{

public static void main(String args[])
{
    System.out.println("checkResult() uses assert() to test replaceDigitN()\n");

    // Add your own test cases below these
    

    checkResult(replaceDigitN(37469, 2, 8), 37869, "called replaceDigitN(37469, 2, 8)") ;
    checkResult(replaceDigitN(37469, 4, 8), 87469, "called replaceDigitN(37469, 4, 8)") ;
    checkResult(replaceDigitN(0, 0, 1), 1, "called replaceDigitN(0, 0, 1)") ;
    checkResult(replaceDigitN(1, 0, 0), 0, "called replaceDigitN(1, 0, 0)") ;
    checkResult(replaceDigitN(78, 1, 5), 58, "called replaceDigitN(78, 1, 5)") ;
    checkResult(replaceDigitN(7843, 3, 1), 1843, "called replaceDigitN(7843, 3, 1)") ;
    checkResult(replaceDigitN(1005678, 6, 0), 5678, "called replaceDigitN(1005678, 6, 0)") ;
    checkResult(replaceDigitN(453267, 3, 0), 450267, "called replaceDigitN(453267, 3, 0)") ;

    System.out.println("Since this is executed, it means all my tests pass!");
}


/*
 * This method will replace the nth digit in num with digit and return the
 * resulting new integer. Use mathematical calculations to determine the answer.
 *
 * Note: digits are counted right to left, and start at 0.
 *
 */

public static int replaceDigitN(int num, int n, int digit)
{
    // you write the code, using mathematical calculations
    int number = (int)((int)(num/Math.pow(10,n+1)) * Math.pow(10, n+1)) + (int)(digit * Math.pow(10, n));
    int newDigit = ((int)(num % Math.pow(10, n+1))) % (int)(Math.pow(10, n));
    return number + newDigit;
}

/*
 * Call this method from main() with
 *
 *   - the result from your call to replaceDigit(),
 *   - the expected result (hardcoded in your call),
 *   - the failure message to print if they do not match.
 *
 */

public static void checkResult(int result, int expectedResult, String msg)
{
    
    // Note: this is a trace statement. It is meant to help you debug.
    //       You would normally comment it out before turning in your code,
    //       but please leave it in for this assignment.

    System.out.println("Does " + result + " equal " + expectedResult + "?");

    boolean traceResult = true;
    String errorMsg = "\n**Fail " + msg 
                        + " Result: " + result
                        + " Expected " + expectedResult;
    assert result == expectedResult : errorMsg;
    if (traceResult)
        System.out.println("Success: " + msg + " is " + expectedResult +"\n");
}
}