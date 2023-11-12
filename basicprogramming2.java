import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class basicprogramming2 
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int instruction = s.nextInt();
        int[] arr = new int[N];
        for( int i = 0; i < N; i++ )
        {
            arr[i] = s.nextInt();
        }
        if( instruction == 1 )
        {
            ArrayList<Integer> check = new ArrayList<>();
            for( int n : arr )
            {
                if( n < 7778 )
                {
                    check.add(n);
                }
            }
            for( int i = 0; i < check.size() ; i++ )
            {
                for( int j = i + 1; j < check.size(); j++ )
                {
                    if( check.get(i) + check.get(j) == 7777 )
                    {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
            System.out.println("No");
            return;
        }
        else if( instruction == 2 )
        {
            HashSet<Integer> duplicate = new HashSet<>();
            for(int n : arr)
            {
                duplicate.add(n);
            }
            if( N == duplicate.size() )
            {
                System.out.println("Unique");
            }
            else
            {
                System.out.println("Contains duplicate");
            }
        }
        else if( instruction == 3 )
        {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int n : arr)
            {
                hm.put(n, hm.getOrDefault(n, 0) + 1);
            }
            for( Map.Entry<Integer, Integer> entry : hm.entrySet() )
            {
                if( entry.getValue() > N / 2.0)
                {
                    System.out.println(entry.getKey());
                    return;
                }
            }
            System.out.println(-1);
        }
        else if( instruction == 4 )
        {
            Arrays.sort(arr);
            if( N % 2 == 1 )
            {
                System.out.println(arr[N/2]);
            }
            else
            {
                System.out.println(arr[N/2 - 1] + " " + arr[N/2]);
            }
        }
        else
        {
            Arrays.sort(arr);
            for( int n : arr )
            {
                if( n >= 100 && n <= 999 )
                {
                    System.out.print(n + " ");
                }
            }
        }
    }
}
