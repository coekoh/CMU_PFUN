/**
 * This is a helper class for encapsulating a TestScore. It is not complete.
 * 
 * Note: no comments on purpose! See if you can folllow the code.
 * 
 *  @author Cathy Bishop
 */

public class TestScore
{
    private int points;
    private int maxPoints;

    public TestScore()
    {
        points = 0;
        maxPoints = 20;
    }
    public TestScore(int score, int maxScore)
    {
        points = score;
        maxPoints = maxScore;
    }

    public double getPercentage() { return((double) points/maxPoints); }

    public String getLetterGrade()
    {
        double percent = getPercentage() * 100;

        if (percent >= 90)
            return "A";
        if (percent >= 80)
            return "B";
        if (percent >= 70)
            return "C";
        if (percent >= 60)
            return "D";
        return "F";
    }

    public void setPoints(int score, int maxScore)
    {
        points = score;
        maxPoints = maxScore;
    }

    public void setPoints(int score) { points = score; }
    public void setMaxPoints(int maxScore) { maxPoints = maxScore; }

    public String toString()
    {
        return("Score: " + points + " out of " + maxPoints);
    }
}