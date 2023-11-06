import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class height 
{
    public static void main(String[] args) {
        // Given the heights of 20 students
        // Placed in line in order of height
        // Count how many steps taken back by the time line is fully formed
        // e.g., 10 11 15 17 in line, put in 13, 2 steps taken back in total
        // how to tell how many steps taken back per insertion? -> the number of elements - the position of insertion
        // data structure: ArrayList
        // algorithm: brute force, scan arraylist until height that is greater than the one being inserted is found 
        Scanner s = new Scanner(System.in);
        int numCases = s.nextInt();
        int result = 0;
        List<Integer> heights = new ArrayList<>();
        for( int i = 0; i < numCases; i++ )
        {
            s.nextInt();
            heights.add(s.nextInt());
            for( int j = 0; j < 19; j++ )
            {
                int current = s.nextInt();
                for( int k = 0; k < heights.size(); k++ )
                {
                    if( heights.get(k) > current )
                    {
                        result += heights.size() - k;
                        heights.add(k, current);
                        break;
                    }
                    if( k == heights.size() - 1 )
                    {
                        heights.add(current);
                        break;
                    }
                }
            }
            System.out.println(i + 1 + " " + result);
            result = 0;
            heights.clear();
        }
    }
}
