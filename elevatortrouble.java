import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;

public class elevatortrouble 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int floors = s.nextInt();
        int start = s.nextInt();
        int goal = s.nextInt();
        int up = s.nextInt();
        int down = s.nextInt();
        int result = 0;
        int current;
        boolean found = false;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> pq = new LinkedList<>();
        pq.add(start);
        pq.add(-1);
        visited.add(start);
        while( !pq.isEmpty() )
        {
            current = pq.remove();
            if( current == goal )
            {
                found = true;
                break;
            }
            
            if( current == -1 )
            {
                result++;
                if( pq.isEmpty() )
                {
                    break;
                }
                pq.add(-1);
                continue;
            }

            if( current + up <= floors )
            { 
                if( !visited.contains(current + up) )
                {
                    pq.add(current + up);
                    visited.add(current + up);
                }
            }
            if( current - down >= 1 )
            {
                if( !visited.contains(current - down) )
                {
                    pq.add(current - down);
                    visited.add(current - down);
                }
            }
        }
        if( found )
        {
            System.out.print(result);
        }
        else
        {
            System.out.print("use the stairs");
        }
    }    
}
