import java.util.Scanner;

public class speedlimit 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        StringBuilder result = new StringBuilder();
        while( n != -1 )
        {
            int distance = 0;
            int time = 0;
            int newTime = 0;
            int speed;
            for( int i = 0; i < n; i++ )
            {
                speed = s.nextInt();
                newTime = s.nextInt();
                distance += speed * (newTime - time);
                time = newTime;
            }
            n = s.nextInt();
            result.append(distance).append(" miles\n");
        }
        System.out.print(result);
    }  
}
