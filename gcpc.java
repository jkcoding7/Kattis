import java.util.Scanner;
import java.util.HashSet;

public class gcpc
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();
        int[][] scores = new int[n][2];
        HashSet<Integer> above = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for( int i = 0; i < m; i++ )
        {
            int rank = 1;
            int team = s.nextInt();
            int penalty = s.nextInt();
            s.nextLine();
            scores[team - 1][0] += 1;
            scores[team - 1][1] += penalty;
            if( team == 1 )
            {
                HashSet<Integer> remove = new HashSet<>();
                for( int t : above )
                {
                    if( scores[t - 1][0] < scores[team - 1][0] )
                    {
                        remove.add(t);
                    }
                    else if( scores[t - 1][0] == scores[team - 1][0] )
                    {
                        if( scores[t - 1][1] >= scores[team - 1][1] )
                        {
                            remove.add(t);
                        }
                    }
                }
                above.removeAll(remove);
            }
            else
            {
                if( scores[team - 1][0] > scores[0][0] )
                {
                    above.add(team);
                }
                else if( scores[team - 1][0] == scores[0][0] )
                {
                    if( scores[team - 1][1] < scores[0][1] )
                    {
                        above.add(team);
                    }
                }
            }
            result.append(above.size() + 1 + "\n");
        }
        System.out.print(result);
    }
}