import java.util.Scanner;
import java.util.Arrays;

public class ballotboxes
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int B = s.nextInt();
        StringBuilder result = new StringBuilder();
        while( N != -1 )
        {
            int[] population = new int[N + 1];
            int[] ballots = new int[N + 1];
            Arrays.fill(ballots, 1);
            Arrays.sort(population);
            for( int i = 1; i < N + 1; i++ )
            {
                population[i] = s.nextInt();
            }
            while( B-- > N )
            {
                int maxIndex = 0;
                for( int i = 1; i < N + 1; i++ )
                {
                    if( (double) population[i] / ballots[i] > (double) population[maxIndex] / ballots[maxIndex] )
                    {
                        maxIndex = i;
                    }
                }
                ballots[maxIndex]++;
            }
            double[] ratio = new double[N + 1];
            for( int i = 1; i < N + 1; i++ )
            {
                ratio[i] = (double) population[i] / ballots[i];
            }
            Arrays.sort(ratio);
            result.append((int) Math.ceil(ratio[N])).append("\n");
            N = s.nextInt();
            B = s.nextInt();
        }
        System.out.print(result);
    }
}