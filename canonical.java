import java.util.Scanner;
import java.util.Arrays;

public class canonical 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int[] denominations = new int[s.nextInt()];
        for( int i = 0; i < denominations.length; i++ )
        {
            denominations[i] = s.nextInt();
        }
        int[] dp = new int[denominations[denominations.length-1] + denominations[denominations.length - 2]];
        Arrays.fill(dp, 0, dp.length, Integer.MAX_VALUE);
        dp[0] = 0;
        for( int i = 1; i < dp.length; i++ )
        {
            for( int denom : denominations )
            {
                if( i - denom >= 0 )
                {
                    dp[i] = Math.min(dp[i - denom] + 1, dp[i]);
                }
            }
        }
        int[] greedy = new int[dp.length];
        greedy[0] = 0;
        int numCoins;
        int change;
        for( int i = 1; i < greedy.length; i++ )
        {
            numCoins = 0;
            change = i;
            for( int j = denominations.length - 1; j >= 0; j-- )
            {
                while( change >= denominations[j] )
                {
                    
                    numCoins += change / denominations[j];
                    change %= denominations[j];
                }
            }
            greedy[i] = numCoins;            
        }
        for( int i = 0; i < greedy.length; i++ )
        {
            if( greedy[i] != dp[i] )
            {
                System.out.print("non-canonical");
                System.exit(0);
            }
        }
        System.out.print("canonical");
    }    
}