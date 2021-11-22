import javax.swing.*;

public class MergeSort
{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please enter a single positive integer");
            System.exit(1);
        }

        int num = Integer.parseInt(args[0]);

        if (num <= 0) {
            System.err.println("Please enter a positive integer");
            System.exit(1);
        }

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 2 * num);
        StdDraw.setYscale(0, num);

        Value[] arr = new Value[num];
        int min = num + 1;
        Value minValue = null;

        for (int i = 0; i < num; i++) {
            arr[i] = new Value((int) (Math.random() * num) + 1);

            if (arr[i].getValue() < min) {
                min = arr[i].getValue();
                minValue = arr[i];
            }
        }

        for (int i = 0; i < num; i++) {
            if (arr[i] == minValue) {
                double hz = 440;
                arr[i].setSound(hz);
            } else {
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

        mergesort(arr);
    }

    public static void mergesort (Value[] arr)
    {
        mergesort_helper(arr, 0, arr.length);
    }

    public static void mergesort_helper(Value[] arr, int low, int high) {
        if (high - low <= 1)
        {
            draw(arr, low, high - 1);
            return;
        }
        else
        {
            int mid = low + (high - low) / 2;
            mergesort_helper(arr, low, mid);
            mergesort_helper(arr, mid, high);

            merge(arr, low, high);
        }
    }

        public static void merge (Value[] arr, int low, int high)
        {
            int mid =  low + (high - low) / 2;
            Value[] merged = new Value[high - low];
            int low_i = low;
            int upp_i = mid;

            for (int mer_i = 0; mer_i < merged.length; mer_i++)
            {
                if (low_i == mid)
                {
                    while (upp_i < high)
                    {
                        merged[mer_i] = arr[upp_i];
                        upp_i++;
                        mer_i++;
                    }
                    break;
                }
                else if (upp_i == high)
                {
                    while (low_i < mid)
                    {
                        merged[mer_i] = arr[low_i];
                        low_i++;
                        mer_i++;
                    }
                    break;
                }
                else if (arr[low_i].getValue() < arr[upp_i].getValue())
                {
                    merged[mer_i] = arr[low_i];
                    low_i++;
                }
                else
                {
                    merged[mer_i] = arr[upp_i];
                    upp_i++;
                }
            }

            for (int i = 0; i < merged.length; i++)
            {
                arr[low + i] = merged[i];
            }

            draw(arr, low, high - 1);
        }

        public static void draw(Value[] arr, int low, int high)
        {
            for (int i = 0; i < arr.length; i++)
            {
                if ((i >= low) && (i <= high))
                {
                    arr[i].draw(arr.length, i + 1, 2);
                    StdAudio.play(arr[i].getSound());
                }
                else
                {
                    arr[i].draw(arr.length, i + 1, 1);
                    StdAudio.play(arr[i].getSound());
                }
            }

            if((high - low) != arr.length - 1)
            {
                StdDraw.clear();
            }
        }
}



