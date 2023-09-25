import java.util.Scanner;

public class tricktreat
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        StringBuilder result = new StringBuilder();
        while( n != 0 )
        {
            double[][] points = new double[n][2];
            double minX = Double.MAX_VALUE;
            double maxX = Double.NEGATIVE_INFINITY;
            for( int i = 0; i < n; i++ )
            {
                points[i][0] = s.nextDouble();
                points[i][1] = s.nextDouble();
                if( points[i][0] < minX )
                {
                    minX = points[i][0];
                }
                if( points[i][0] > maxX )
                {
                    maxX = points[i][0];
                }
            }
            
            double margin = Math.pow(10, -5);
            double minimizedMax = Double.MAX_VALUE;
            while( minX <= maxX )
            {
                double localMax = findFurthest(points, minX);
                if( localMax > minimizedMax )
                {
                    minX -= margin;
                    break;
                }
                minimizedMax = localMax;
                if( minX == maxX )
                {
                    break;
                }
                minX += margin;
            }
            result.append(minX).append(" ").append(minimizedMax).append("\n");
            n = s.nextInt();
        }
        System.out.print(result);
    }

    public static double findFurthest(double[][] pPoints, double pX)
    {
        double maxDistance = -1;
        double length;
        for( int i = 0; i < pPoints.length; i++ )
        {
            length = Math.sqrt(Math.pow(pX - pPoints[i][0], 2) + Math.pow(pPoints[i][1], 2));
            if( length > maxDistance )
            {
                maxDistance = length;
            }
        }
        return maxDistance;
    }
}