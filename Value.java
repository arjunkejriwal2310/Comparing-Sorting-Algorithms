public class Value
{
    private int val;
    private double[] sound;
    private int n = 4410;
    private int samplingRate = 44100;

    public Value (int val)
    {
        this.val = val;
        sound = new double[n];
    }

    public int getValue()
    {
        return this.val;
    }

    public double[] getSound()
    {
        return this.sound;
    }

    public int compareTo(Value other)
    {
        if (this.val > other.val)
        {
            return 1;
        }
        else if (this.val == other.val)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

    public void setSound(double hz)
    {
        for (int i = 0; i < n; i++)
        {
            this.sound[i] = Math.sin(2 * Math.PI * i * hz / samplingRate);
        }
    }

    public void draw(int totalNum, int currentNum, int color)
    {
        if (color == 1)
        {
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledRectangle(this.val, (totalNum - currentNum + 0.5), this.val, 0.5);
        }
        else if (color == 2)
        {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(this.val, (totalNum - currentNum + 0.5), this.val, 0.5);
        }
        else if (color == 3)
        {
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.filledRectangle(this.val, (totalNum - currentNum + 0.5), this.val, 0.5);
        }
    }




}
