import java.util.Scanner;

public class queens 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[][] positions = new int[N][2];
        boolean possible = true;
        for( int i = 0; i < N; i++ )
        {
            positions[i][0] = s.nextInt();
            positions[i][1] = s.nextInt();
        }
        for( int i = 0; i < N - 1; i++ )
        {
            for( int j = i + 1; j < N; j++ )
            {
                if( positions[i][0] == positions[j][0] || positions[i][1] == positions[j][1] )
                {
                    possible = false;
                }
                
                if( checkDiagonal(positions[i], positions[j]) )
                {
                    possible = false;
                }
            }
        }

        System.out.print(possible ? "CORRECT" : "INCORRECT" );
    }

    public static boolean checkDiagonal(int[] position1, int[] position2)
    {
        int diff1 = Math.abs(position1[0] - position2[0]);
        int diff2 = Math.abs(position1[1] - position2[1]);
        return diff1 == diff2;
    }
}
