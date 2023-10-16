import java.util.Scanner;
import java.util.Arrays;

public class color 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int numSocks = s.nextInt();
        int capacity = s.nextInt();
        int maxDiff = s.nextInt();
        int[] colors = new int[numSocks];
        for( int i = 0; i < numSocks; i++ )
        {
            colors[i] = s.nextInt();
        }
        Arrays.sort(colors);
        int result = 1;
        int socks = 1;
        int minColor = colors[0];
        for( int i = 1; i < numSocks; i++ )
        {
            if( socks < capacity && colors[i] - minColor <= maxDiff )
            {
                socks++;
            }
            else
            {
                result++;
                socks = 1;
                minColor = colors[i];
            }
        }
        System.out.print(result);
    }    
}
