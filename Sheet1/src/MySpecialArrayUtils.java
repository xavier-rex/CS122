import java.util.Arrays;

public class MySpecialArrayUtils implements Methods
{
    public void reverse(int[] arr)
    {
        if (arr.length == 0)
        {
            System.out.println("Your array is empty");
        }
        else
        {
            int tmp;
            for (int i = 0; i < arr.length / 2; i++)
            {
                tmp = arr[i];
                arr[i] = arr[arr.length - i];
                arr[arr.length - i] = tmp;
            }
        }

    }

    public int[] sumEvenOdd(int[] arr)
    {
        int[] answer = new int[2];
        Arrays.fill(answer, 0);

        if (arr.length == 0)
        {
            return answer;
        }

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                answer[0] += arr[i];
            }
            else
            {
                answer[1] += arr[i];
            }
        }
        return answer;
    }

    public double average(int[] arr)
    {
        if (arr.length == 0)
        {
            return 0;
        }

        double sum = 0;
        for (int num : arr)
        {
            num /= arr.length;
            sum += num;
        }
        return sum;
    }

    public void moveValue(int[] arr, int val)
    {
        Arrays.sort(arr);
        int index;
        int counter = 0;
        do
        {
            index = Arrays.binarySearch(arr, 0, arr.length - counter,val);
            if (index >= 0)
            {
                int tmp = arr[index];
                arr[index] = arr[arr.length - counter];
                arr[arr.length - counter] = tmp;
            }
            Arrays.sort(arr, 0, arr.length - counter);
        }while (index >= 0);
    }

    public int[][] transpose(int[][] arr)
    {
        int[][] ans = {{0,0}};
        if (arr.length == 0)
        {
            return ans;
        }

        ans = new int[arr[0].length][arr.length];

        for (int[] num : arr)
        {
            Arrays.fill(num, 0);
        }

        for (int i = 0; i < arr[0].length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                ans[i][j] = arr[j][i];
            }
        }

        return ans;
    }

    public long fib(long n)
    {
        if(n <= 1)
        {
            return n;
        }
        long fib = 1;
        long prevFib = 1;

        for(int i = 2; i < n; i++)
        {
            long tmp = fib;
            fib += prevFib;
            prevFib = tmp;
        }
        return fib;
    }

}
