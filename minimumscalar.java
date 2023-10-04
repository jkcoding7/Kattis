import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;;

public class minimumscalar 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int length;
        int num = 1;
        
        for( int i = 0; i < T; i++ )
        {
            BigInteger min = new BigInteger("0");
            length = s.nextInt();
            int[] v1 = new int[length];
            int[] v2 = new int[length];
            for( int j = 0; j < length; j++ )
            {
                v1[j] = s.nextInt();
            }
            for( int j = 0; j < length; j++ )
            {
                v2[j] = s.nextInt();
            }
            Arrays.sort(v1);
            Arrays.sort(v2);
            for( int j = 0; j < length; j++ )
            {
                min = min.add(BigInteger.valueOf(v1[j]).multiply(BigInteger.valueOf(v2[length - 1 - j])));
            }
            System.out.println("Case #" + num + ": " + min);
            num++;
        }
    }
}
