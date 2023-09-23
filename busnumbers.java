import java.util.Scanner;
import java.util.Arrays;

public class busnumbers
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        
        int[] busNumbers = new int[N];
        for ( int i = 0; i < N; i++ )
        {
            busNumbers[i] = s.nextInt();
        }
        Arrays.sort(busNumbers);
        
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < N; i++ )
        {
            result.append(busNumbers[i]);
            int consecutives = 0;
            while (  i < N - 1 && busNumbers[i] + 1 == busNumbers[i + 1] )
            {
                consecutives++;
                i++;
            }
            
            if ( consecutives > 1 )
            {
                result.append("-" + 
                              busNumbers[i] + " ");
            }
            else if ( consecutives == 1 )
            {
                result.append(" " + busNumbers[i] + " ");
            }
            else
            {
                result.append(" ");
            }
        }
        
        System.out.print(result.toString().trim());
    }
}