import java.util.Arrays;
import java.util.Scanner;

public class lawnmower 
{
    public static void main(String[] args) {
        // sort horizontal and vertical cuts in ascending order
        // Algorithm: keep a left and right pointer to track cut coverage
        // Data structure: arrays
        Scanner s = new Scanner(System.in);
        int numHorizontalCuts = s.nextInt();
        int numVerticalCuts = s.nextInt();
        double mowerWidth = s.nextDouble() / 2;
        int fieldLength = 100;
        int fieldWidth = 75;
        while( numHorizontalCuts != 0 && numVerticalCuts != 0 && mowerWidth != 0 )
        {
            boolean possible = true;
            double coverageHorizontal = 0;
            double coverageVertical = 0;
            double[] horizontalCuts = new double[numHorizontalCuts];
            double[] verticalCuts = new double[numVerticalCuts];
            for( int i = 0; i < numHorizontalCuts; i++ )
            {
                horizontalCuts[i] = s.nextDouble();
            }
            Arrays.sort(horizontalCuts);
            
            for( int i = 0; i < numVerticalCuts; i++ )
            {
                verticalCuts[i] = s.nextDouble();
            }
            Arrays.sort(verticalCuts);

            for( int i = 0; i < numHorizontalCuts; i++ )
            {
                if( horizontalCuts[i] - mowerWidth > coverageHorizontal )
                {
                    possible = false;
                    break;
                }
                coverageHorizontal = horizontalCuts[i] + mowerWidth;
            }
            
            for( int i = 0; i < numVerticalCuts; i++ )
            {
                if( !possible )
                {
                    break;
                }
                if( verticalCuts[i] - mowerWidth > coverageVertical )
                {
                    possible = false;
                    break;
                }
                coverageVertical = verticalCuts[i] + mowerWidth;
            }
            if( coverageHorizontal < fieldWidth )
            {
                possible = false;
            }
            if( coverageVertical < fieldLength )
            {
                possible = false;
            }
            System.out.println(possible ? "YES" : "NO");
            numHorizontalCuts = s.nextInt();
            numVerticalCuts = s.nextInt();
            mowerWidth = s.nextDouble() / 2;
        }
    }    
}
