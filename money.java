import java.util.Scanner;
import java.util.Arrays;

public class money 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] producers = new int[m][2];
        int[][] consumers = new int[n][2];
        for( int i = 0; i < m; i++ )
        {
            producers[i][0] = s.nextInt();
            producers[i][1] = s.nextInt();
        }
        for( int i = 0; i < n; i++ )
        {
            consumers[i][0] = s.nextInt();
            consumers[i][1] = s.nextInt();
        }

        int maxProfit = 0;
        int profit = 0;
        for( int i = 0; i < m; i++ )
        {
            for( int j = 0; j < n; j++ )
            {
                if( consumers[j][0] - producers[i][0] <= 0 || consumers[j][1] - producers[i][1] <= 0 )
                {
                    continue;
                }
                profit = (consumers[j][0] - producers[i][0]) * (consumers[j][1] - producers[i][1]);
                if( profit > maxProfit )
                {
                    maxProfit = profit;
                }
            }
        }
        if( maxProfit == 0 )
        {
            System.out.print("0");
        }
        else
        {
            System.out.print(maxProfit);
        }
    }
}
