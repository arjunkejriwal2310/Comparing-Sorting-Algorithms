public class InsertionSort
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.err.println("Please enter a single positive integer");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);

        if (num <= 0)
        {
            System.err.println("Please enter a positive integer");
            System.exit(1);
        }

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 2 * num);
        StdDraw.setYscale(0, num);

        Value[] arr = new Value[num];
        int min = num + 1;
        Value minValue = null;

        for (int i = 0; i < num; i++)
        {
            arr[i] = new Value ((int)(Math.random() * num) + 1);

            if (arr[i].getValue() < min)
            {
                min = arr[i].getValue();
                minValue = arr[i];
            }
        }

        for (int i = 0; i < num; i++)
        {
            if (arr[i] == minValue)
            {
                double hz = 440;
                arr[i].setSound(hz);
            }
            else
            {
                int x = arr[i].getValue();
                double hz = 440 * Math.pow(2, (x - min) / 12.0);
                arr[i].setSound(hz);
            }
        }

        for (int i = 0; i < num; i++)
        {
            arr[i].draw(num, i+1, 1);
            StdAudio.play(arr[i].getSound());
        }

        StdDraw.clear();
        Value original = null;

        for (int i = 0; i < num; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (arr[j-1].compareTo(arr[j]) > 0)
                {
                    Value temp = arr[j];
                    if (j == i)
                    {
                        original = arr[j];
                    }
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    StdDraw.clear();
                }
                else
                {
                    break;
                }

                for (int k = 0; k < num; k++)
                {
                    if (k == j - 1)
                    {
                        arr[k].draw(num, k + 1, 3);
                        StdAudio.play(arr[k].getSound());
                    }
                    else
                    {
                        arr[k].draw(num, k + 1, 1);
                        StdAudio.play(arr[k].getSound());
                        if (k == i)
                        {
                            original.draw(num, i + 1, 2);
                        }
                    }
                }
            }
        }
    }
}
