import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class plantingtrees 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] trees = new int[N];
        for( int i = 0; i < N; i++ )
        {
            trees[i] = s.nextInt();
        }
        Arrays.sort(trees);
        int j = 0;
        for( int i = N - 1; i >= 0; i-- )
        {
            trees[i] += j + 2;
            j++;
        }
        Arrays.sort(trees);
        System.out.print(trees[N-1]);
    }    
}
