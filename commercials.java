import java.util.Scanner;

public class commercials 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int P = s.nextInt();
        int[] nums = new int[N];
        for( int i = 0; i < N; i++ )
        {
            nums[i] = s.nextInt();
        }
        int maxValue = Integer.MIN_VALUE;
        int curMax = 0;
        for( int i = 0; i < N; i++ )
        {
            curMax += nums[i] - P;
            if( curMax < 0 )
            {
                curMax = 0;
            }
            if( curMax > maxValue )
            {
                maxValue = curMax;
            }
        }
        System.out.print(maxValue);
    }   
}
