import java.util.Scanner;

public class telephones
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        StringBuilder result = new StringBuilder();
        while( N != 0 )
        {
            s.nextLine();
            int[] startTimes = new int[N];
            int[] finishTimes = new int[N];
            for( int i = 0; i < N; i++ )
            {
                String[] call = s.nextLine().split(" ");
                startTimes[i] = Integer.parseInt(call[2]);
                finishTimes[i] = startTimes[i] + Integer.parseInt(call[3]);
            }
            for( int i = 0; i < M; i++)
            {
                int activeCalls = 0;
                int start = s.nextInt();
                int finish = start + s.nextInt();
                s.nextLine();
                for( int j = 0; j < startTimes.length; j++ )
                {
                    if( finish > startTimes[j] && start < finishTimes[j] )
                    {
                        activeCalls++;
                    }
                }
                result.append(activeCalls).append("\n");
            }
            N = s.nextInt();
            M = s.nextInt();
        }
        System.out.print(result);
    }
}