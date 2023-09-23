import java.util.Scanner;

public class permutationencryption
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        boolean status = true;

        while (status)
        {
            int n = s.nextInt();
            if ( n == 0 )
            {
                status = false;
                continue;
            }
            
            result.append("'");

            String[] key = s.nextLine().trim().split("\\s");
            String message = s.nextLine();
            
            if ( message.length() % n != 0 )
            {
                int padWidth = n - (message.length() % n);
                
                for ( int i = 0; i < padWidth; i++ )
                {
                    message += " ";
                }
            }
            
            for ( int i = 0; i < message.length() / n; i++ )
            {
                for ( int j = 0; j < n; j++ )
                {
                    result.append(message.charAt(i * n + Integer.parseInt(key[j]) - 1));
                }
            }
            result.append("'\n");
        }

        System.out.print(result.toString());
    }
}