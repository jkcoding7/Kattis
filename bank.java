import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Collections;

public class bank
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int T = s.nextInt();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        int result = 0;
        for( int j = 0; j < T; j++ )
        {
            hm.put(j, new ArrayList<Integer>());
        }
        for( int i = 0; i < N; i++ )
        {
            int amount = s.nextInt();
            int time = s.nextInt();
            
            for( int j = 0; j <= time; j++ )
            {
                hm.get(j).add(amount);
            }
        }
        for( int i = T - 1; i >= 0; i-- )
        {
            if( !hm.get(i).isEmpty() )
            {
                int max = Collections.max(hm.get(i));
                result += max;
                for( int j = i; j >= 0; j-- )
                {
                    hm.get(j).remove(Integer.valueOf(max));
                }
            }
        }
        System.out.print(result);
    }
}