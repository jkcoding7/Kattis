import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pvbg 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(s.readLine());
        int min = Integer.MAX_VALUE;
        int cur;
        String[] waves = s.readLine().split(" ");
        for( int i = 0; i < n; i++ )
        {
            cur = Integer.parseInt(waves[i]);
            min = Math.min(min, cur);
        }
        System.out.print(min + 1);
    }
}
