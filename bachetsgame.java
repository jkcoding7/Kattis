import java.util.Scanner;

public class bachetsgame 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int numStones;
        int numMoves;
        StringBuilder result = new StringBuilder();
        while( s.hasNextInt() )
        {   
            numStones = s.nextInt();
            numMoves = s.nextInt();
            int[] moves = new int[numMoves];
            for( int i = 0; i < numMoves; i++ )
            {
                moves[i] = s.nextInt();
            }
            int[] table = new int[numStones + 1];
            for( int i = 1; i < table.length; i++ )
            {
                for( int j = 0; j < numMoves; j++ )
                {
                    if( i - moves[j] >= 0 && table[i - moves[j]] == 0 )
                    {
                        table[i] = 1;
                        break;
                    }
                }
            }
            if( table[numStones] ==  0 )
            {
                result.append("Ollie wins\n");
            }
            else
            {
                result.append("Stan wins\n");
            }
        }
        System.out.print(result);
    }
}