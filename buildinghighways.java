import java.util.Scanner;
import java.util.Arrays;

public class buildinghighways 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] cost = new int[n];
        for( int i = 0; i < n; i++ )
        {
            cost[i] = s.nextInt();
        }
        Arrays.sort(cost);
        int result = 0;
        for( int i = 0; i < n - 1; i++ )
        {
            if( n == 1 )
            {
                break;
            }
            result += cost[0] + cost[i+1];
        }
        System.out.print(result);
    }
}
