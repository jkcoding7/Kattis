import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;

public class moneymatters 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] debts = new int[n];
        for( int i = 0; i < n; i++ )
        {
            debts[i] = s.nextInt();
        }
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        int[] parent = new int[n];
        Arrays.fill(parent, 0, parent.length, -1);
        for( int i = 0; i < m; i++ )
        {
            int friend1 = s.nextInt();
            int friend2 = s.nextInt();
            if( parent[friend1] == -1 && parent[friend2] == -1 )
            {
                parent[friend1] = friend1;
                parent[friend2] = friend1;
                hm.put(friend1, new HashSet<Integer>());
                hm.get(friend1).add(friend1);
                hm.get(friend1).add(friend2);
            }
            else if( parent[friend1] == -1 )
            {
                parent[friend1] = parent[friend2];
                hm.get(parent[friend2]).add(friend1);
            }
            else if( parent[friend2] == -1 )
            {
                parent[friend2] = parent[friend1];
                hm.get(parent[friend1]).add(friend2);
            }
            else if( parent[friend1] != parent[friend2] )
            {
                if( hm.get(parent[friend1]).size() < hm.get(parent[friend2]).size() )
                {
                    int prev = parent[friend1];
                    for( Integer curr : hm.get(parent[friend1]) )
                    {
                        parent[curr] = parent[friend2];
                    }
                    hm.get(parent[friend2]).addAll(hm.get(prev));
                    hm.remove(prev);
                }
                else
                {
                    int prev = parent[friend2];
                    for( Integer curr : hm.get(parent[friend1]) )
                    {
                        parent[curr] = parent[friend1];
                    }
                    hm.get(parent[friend1]).addAll(hm.get(prev));
                    hm.remove(prev);
                }
            }
        }

        for( Map.Entry<Integer, HashSet<Integer>> entry : hm.entrySet() )
        {
            HashSet<Integer> check = entry.getValue();
            int balance = 0;
            for( Integer index : check )
            {
                balance += debts[index];
                debts[index] = 0;
            }
            if( balance != 0 )
            {
                System.out.print("IMPOSSIBLE");
                System.exit(0);
            }
        }
        for( int i = 0; i < n; i++ )
        {
            if( debts[i] != 0 )
            {
                System.out.print("IMPOSSIBLE");
                System.exit(0);
            }
        }
        System.out.print("POSSIBLE");
    }
}
