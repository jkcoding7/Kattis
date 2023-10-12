import java.util.Scanner;

public class grass 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        while ( s.hasNextInt() )
        {
            int n = s.nextInt();
            double length = s.nextInt();
            double width = s.nextInt();
            double b = width / 2.0;
            double[][] dimensions = new double[n][2];
            for( int i = 0; i < n; i++ )
            {
                double x = s.nextInt();
                double r = s.nextInt();
                double coverage = computeA(r, b);
                dimensions[i][0] = x - coverage;
                dimensions[i][1] = x + coverage;
            }
            double covered = 0;
            boolean possible;
            int result = 0;
            while( covered < length )
            {
                possible = false;
                double max = 0;
                for( double[] coverage : dimensions )
                {
                    
                    if( coverage[0] <= covered && coverage[1] > covered )
                    {
                        if( coverage[1] > max )
                        {
                            max = coverage[1];
                            possible = true;
                        }
                    }
                }
                if( !possible )
                {
                    result = -1;
                    break;
                }
                covered = max;
                result++;
            }
            System.out.println(result);
        }
    }

    public static double computeA(double r, double b)
    {
        return Math.sqrt(Math.pow(r, 2) - Math.pow(b, 2));
    }
}
