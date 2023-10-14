import java.util.Scanner;

public class bus 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int k;
        double n = 1;
        while( N-- > 0 )
        {
            k = s.nextInt();
            for( int i = 1; i < k; i++ )
            {
                n = (n + 0.5) * 2;
            }
            System.out.println((int) n);
            n = 1;
        }
    }
}
