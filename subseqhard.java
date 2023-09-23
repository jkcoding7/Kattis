import java.util.Scanner;
import java.util.HashMap;

public class subseqhard
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        StringBuilder result = new StringBuilder();
        while( T-- > 0)
        {
            s.nextLine();
            int N = s.nextInt();
            s.nextLine();
            long[] prefixSum = new long[N + 1];
            for( int i = 0; i < N; i++ )
            {
                prefixSum[i] = s.nextInt();
            }
            for( int i = 1; i < N; i++ )
            {
                prefixSum[i] += prefixSum[i - 1];
            }
            HashMap<Long, Integer> track = new HashMap<>();
            track.put(0L, 1);
            long count = 0;
            for( int i = 0; i < N; i++ )
            {
                long diff = prefixSum[i] - 47;
                if( track.containsKey(diff) )
                {
                    count += track.get(diff);
                }
                track.put(prefixSum[i], track.getOrDefault(prefixSum[i], 0) + 1);
            }
            result.append(count + "\n");
        }
        System.out.print(result);
    }
}