import java.util.Scanner;

public class deduplicatingfiles
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int n = s.nextInt();
        s.nextLine();
        while( n != 0 )
        {
            String[] file = new String[n];
            int[] hash = new int[n];
            for( int i = 0; i < n; i++)
            {
                file[i] = s.nextLine();
                byte output = 0;
                for( byte b : file[i].getBytes() )
                {
                    output ^= b;
                }
                hash[i] = output;
            }
            int unique = 0;
            int collisions = 0;
            for( int i = 0; i < n; i++ )
            {
                boolean isUnique = true;
                for( int j = i + 1; j < n; j++ )
                {
                    if( hash[i] == hash[j] )
                    {
                        if( file[i].equals(file[j]) )
                        {
                            isUnique = false;
                        }
                        else
                        {
                            collisions++;
                        }
                    }
                }
                if( isUnique )
                {
                    unique++;
                }
            }
            result.append(unique).append(" ").append(collisions).append("\n");
            n = s.nextInt();
            s.nextLine();
        }
        System.out.print(result);
    }
}