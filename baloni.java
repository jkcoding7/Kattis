import java.util.Scanner;
import java.util.ArrayList;

public class baloni 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        ArrayList<Integer> currentHeight = new ArrayList<>();
        int[] heights = new int[N];
        for( int i = 0; i < N; i++ )
        {
            heights[i] = s.nextInt();
        }
        int result = 1;
        currentHeight.add(heights[0]);
        for( int i = 1; i < N; i++ )
        {
            if( !currentHeight.contains(heights[i] + 1) )
            {
                result++;
                currentHeight.add(heights[i]);
            }
            else
            {
                currentHeight.remove(currentHeight.indexOf(heights[i] + 1));
                currentHeight.add(heights[i]);
            }
        }
        System.out.print(result);
    }

}
