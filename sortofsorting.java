import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class sortofsorting 
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while( n != 0 )
        {
            s.nextLine();
            String[] names = new String[n];
            for( int i = 0; i < n; i++ )
            {
                names[i] = s.nextLine();
            }
            Arrays.sort(names, firstTwo());
            for(String name : names)
            {
                System.out.println(name);
            }
            System.out.println();
            n = s.nextInt();
        }
    }

    public static Comparator<String> firstTwo()
    {
        return new Comparator<>() {
            public int compare(String s1, String s2)
            {
                s1 = s1.substring(0,2);
                s2 = s2.substring(0, 2);
                return s1.compareTo(s2);
            }
        };
    }
}
