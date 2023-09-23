import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

public class guessthedatastructure
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder("");
        while(scan.hasNextLine())
        {
            int numLines = scan.nextInt();
            scan.nextLine();
            Stack<Integer> s = new Stack<>();
            ArrayList<Integer> q = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            boolean isS = true;
            boolean isQ = true;
            boolean isPQ = true;
            for( int i = 0; i < numLines; i++)
            {
                if ( scan.nextInt() == 1 )
                {
                    int num = scan.nextInt();
                    scan.nextLine();
                    if( isS == true )
                    {
                        s.push(num);
                    }
                    if ( isQ == true )
                    {
                        q.add(num);
                    }
                    if ( isPQ == true )
                    {
                        pq.add(num);
                    }
                }
                else
                {
                    int num = scan.nextInt();
                    scan.nextLine();
                    if( s.empty() || s.pop() != num )
                    {
                        isS = false;
                    }
                    if( q.isEmpty() || q.remove(0) != num )
                    {
                        isQ = false;
                    }
                    if( pq.peek() == null || pq.poll() != num )
                    {
                        isPQ = false;
                    }
                }
            }
            if( isS == true && isQ == false && isPQ == false )
            {
                result.append("stack\n");
            }
            else if( isS == false && isQ == true && isPQ == false )
            {
                result.append("queue\n");
            }
            else if( isS == false && isQ == false && isPQ == true )
            {
                result.append("priority queue\n");;
            }
            else if( isS == false && isQ == false && isPQ == false )
            {
                result.append("impossible\n");;
            }
            else
            {
                result.append("not sure\n");;
            }
        }
        System.out.print(result);
        scan.close();
    }
}