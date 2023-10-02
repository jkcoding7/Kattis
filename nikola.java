import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class nikola 
{
    static int N;
    static int[] cost;
    static int bestScore = Integer.MAX_VALUE;
    static HashMap<int[], Integer> hm = new HashMap<>();
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        cost = new int[N + 1];
        for( int i = 1; i < N + 1; i++ )
        {
            cost[i] = s.nextInt();
        }
        int[] state = {2, 1};
        System.out.print(play(state, cost[2]));
    }   

    public static int play(int[] pState, int pCost)
    {
        int score1 = Integer.MAX_VALUE;
        int score2 = Integer.MAX_VALUE;
        if( pState[0] == N )
        {
            return pCost;
        }

        if( !hm.containsKey(pState) )
        {
            if( pState[0] + pState[1] + 1 <= N )
            {
                int[] copy = Arrays.copyOf(pState, pState.length);
                copy[1] += 1;
                copy[0] += copy[1];
                score1 = play(copy, pCost + cost[copy[0]]);
            }
            if( pState[0] - pState[1] > 0 )
            {
                int[] copy = Arrays.copyOf(pState, pState.length);
                copy[0] -= copy[1];
                score2 = play(copy, pCost + cost[copy[0]]);
            }
            hm.put(pState, Math.min(score1, score2));
        }
        return hm.get(pState);        
    }
}
