import java.util.Scanner;
import java.util.Arrays;

public class pebblesolitaire
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        StringBuilder result = new StringBuilder();
        while( n-- > 0 )
        {
            char[] gameState = s.nextLine().toCharArray();
            int score = 0;
            for( int i = 0; i < gameState.length; i++ )
            {
                if( gameState[i] == 'o' )
                {
                    score++;
                }
            }
            score = play(Arrays.copyOf(gameState, gameState.length), score);
            result.append(score + "\n");
        }
        System.out.print(result);
    }
    
    public static int play(char[] pGameState, int pScore)
    {
        int bestScore = pScore;
        int rScore = pScore;
        int lScore = pScore;
        for( int i = 0; i < pGameState.length; i++ )
        {
            if( pGameState[i] == 'o' )
            {
                if( hasMoveRight(pGameState, i) )
                {
                    char[] newState = Arrays.copyOf(pGameState, pGameState.length);
                    newState[i] = '-';
                    newState[i + 1] = '-';
                    newState[i + 2] = 'o';
                    rScore = play(newState, pScore - 1);
                }

                if( hasMoveLeft(pGameState, i) )
                {
                    char[] newState = Arrays.copyOf(pGameState, pGameState.length);
                    newState[i] = '-';
                    newState[i - 1] = '-';
                    newState[i - 2] = 'o';
                    lScore = play(newState, pScore - 1);
                }
                        
                if( rScore < bestScore )
                {
                    bestScore = rScore;
                }
                else if( lScore < bestScore )
                {
                    bestScore = lScore;
                }
            }
        }
        return bestScore;
    }
    
    public static boolean hasMoveRight(char[] pGameState, int pPosition)
    {
        boolean validMove = true;
        if( pPosition > pGameState.length - 3 )
        {
            validMove = false;
        }
        else if( pGameState[pPosition + 1] == '-' )
        {
            validMove = false;
        }
        else if( pGameState[pPosition + 2] == 'o' )
        {
            validMove = false;
        }
        return validMove;
    }
    
    public static boolean hasMoveLeft(char[] pGameState, int pPosition)
    {
        boolean validMove = true;
        if( pPosition < 2 )
        {
            validMove = false;
        }
        else if( pGameState[pPosition - 1] == '-' )
        {
            validMove = false;
        }
        else if( pGameState[pPosition - 2] == 'o' )
        {
            validMove = false;
        }
        return validMove;
    }
}