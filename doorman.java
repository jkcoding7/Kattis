import java.util.Scanner;

public class doorman
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int maxDiff = s.nextInt();
        s.nextLine();
        char[] line = s.nextLine().toCharArray();
        int men = 0;
        int women = 0;
        for ( int i = 0; i < line.length; i++ )
        {
            if ( line[i] == 'M' )
            {
                men++;
            }
            else
            {
                women++;
            }
            
            if ( Math.abs(men - women) > maxDiff )
            {
                if ( line[i] != line[i+1] )
                {
                    char temp = line[i];
                    line[i] = line[i+1];
                    line[i+1] = temp;
                    if ( temp == 'M' )
                    {
                        men--;
                        women++;
                    }
                    else
                    {
                        women--;
                        men++;
                    }
                }
                else
                {
                    System.out.println(men + women - 1);
                    System.exit(0);
                }
            }
        }
        System.out.println(men + women);
        s.close();
    }
}