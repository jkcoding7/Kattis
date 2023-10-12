import java.util.Scanner;
import java.util.Arrays;

public class pikemaneasy 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int T = s.nextInt();
        long A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        long[] times = new long[N];
        times[0] = s.nextInt();
        for( int i = 1; i < N; i++ )
        {
            times[i] = (A*times[i-1] + B) % C + 1;
        }
        Arrays.sort(times);
        long timePassed = 0;
        int solved = 0;
        long penalty = 0;
        for( int i = 0; i < N && timePassed + times[i] <= T; i++ )
        {
            penalty = (penalty + timePassed + times[i]) % 1000000007;
            timePassed += times[i];
            solved++;
        }
        System.out.print(solved + " " + penalty);
    }
}