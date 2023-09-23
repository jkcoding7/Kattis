import java.util.Scanner;
import java.util.Arrays;

public class closestsums
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int num = 1;
        while( s.hasNextInt() )
        {
            result.append("Case ").append(num).append(":\n");
            int numElements = s.nextInt();
            s.nextLine();
            int[] set = new int[numElements];
            for( int i = 0; i < numElements; i++ )
            {
                set[i] = s.nextInt();
                s.nextLine();
            }
            int[] sums = new int[numElements * (numElements - 1) / 2];
            int k = 0;
            for( int i = 0; i < set.length - 1; i++ )
            {
                for( int j = i + 1; j < set.length; j++ )
                {
                    sums[k] = set[i] + set[j];
                    k++;
                }
            }
            Arrays.sort(sums);
            int numQueries = s.nextInt();
            s.nextLine();
            for( int i = 0; i < numQueries; i++ )
            {
                int sum = s.nextInt();
                s.nextLine();
                int closestSum = sums[0];
                int index = Arrays.binarySearch(sums, sum);
                if( index < 0 )
                {
                    int insertionPoint = (index + 1) * -1;
                    if( insertionPoint == sums.length )
                    {
                        closestSum = sums[sums.length - 1];
                    }
                    else if( insertionPoint == 0 )
                    {
                        closestSum = sums[0];
                    }
                    else 
                    {
                        if( Math.abs(sum - sums[insertionPoint]) < Math.abs(sum - sums[insertionPoint - 1]) )
                        {
                            closestSum = sums[insertionPoint];
                        }
                        else
                        {
                            closestSum = sums[insertionPoint - 1];
                        }
                    }
                }
                else
                {
                    closestSum = sums[index];
                }           
                result.append("Closest sum to ").append(sum).append(" is ").append(closestSum).append(".\n");
            }
            num++;
        }
        System.out.print(result);
    }
}