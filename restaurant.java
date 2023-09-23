import java.util.Scanner;

public class restaurant
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        StringBuilder result = new StringBuilder();
        while( N != 0 )
        {
            s.nextLine();
            int p1 = 0;
            int p2 = 0;
            for( int i = 0; i < N; i++ )
            {
                String[] request = s.nextLine().split(" ");
                String order = request[0];
                int m = Integer.parseInt(request[1]);
                if( order.equals("DROP") )
                {
                    p2 += m;
                    result.append("DROP 2 ").append(m).append("\n");
                }
                else if( order.equals("TAKE") )
                {
                    if( p1 >= m )
                    {
                        result.append("TAKE 1 ").append(m).append("\n");
                        p1 -= m;
                    }
                    else
                    {
                        if( p1 < m && p1 != 0 )
                        {
                            m -= p1;
                            result.append("TAKE 1 ").append(p1).append("\n");
                            p1 = 0;
                        }
                        result.append("MOVE 2->1 ").append(p2).append("\n");
                        p1 = p2;
                        p2 = 0;
                        result.append("TAKE 1 ").append(m).append("\n");
                        p1 -= m;
                    }
                }
            }
            result.append("\n");
            N = s.nextInt();
        }
        System.out.print(result);
    }
}