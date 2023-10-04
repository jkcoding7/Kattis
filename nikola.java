import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class nikola 
{
    static int N;
    static int[] cost;
    static int bestScore = Integer.MAX_VALUE;
    static HashMap<State, Integer> hm = new HashMap<>();
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        cost = new int[N + 1];
        for( int i = 1; i < N + 1; i++ )
        {
            cost[i] = s.nextInt();
        }
        State state = new State(2, 1);
        System.out.print(play(state, cost[2]));
    }   

    public static int play(State pState, int pCost)
    {
        int score1 = Integer.MAX_VALUE;
        int score2 = Integer.MAX_VALUE;
        if( pState.aSquare == N )
        {
            return pCost;
        }

        if( !hm.containsKey(pState) )
        {
            if( pState.aSquare + pState.aLength + 1 <= N )
            {
                State copy = new State(pState.aSquare, pState.aLength);
                copy.aLength += 1;
                copy.aSquare += copy.aLength;
                score1 = play(copy, pCost + cost[copy.aSquare]);
            }
            if( pState.aSquare - pState.aLength > 0 )
            {
                State copy = new State(pState.aSquare, pState.aLength);
                copy.aSquare -= copy.aLength;
                score2 = play(copy, pCost + cost[copy.aSquare]);
            }
            hm.put(pState, Math.min(score1, score2));
        }
        return hm.get(pState);        
    }

    public static class State
    {
        public int aSquare;
        public int aLength;

        public State(int pSquare, int pLength)
        {
            aSquare = pSquare;
            aLength = pLength;
        }
    }
}
