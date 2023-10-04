import java.util.Scanner;
import java.util.Arrays;

public class shopaholic 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] prices = new int[n];
        for( int i = 0; i < n; i++ )
        {
            prices[i] = s.nextInt();
        }
        Arrays.sort(prices);
        long result = 0;
        for( int i = n - 3; i >= 0; i = i-3 )
        {
            result += prices[i];
        }
        System.out.print(result);
    }
}
