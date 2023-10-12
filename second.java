import java.util.Scanner;

public class second 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ones = n % 10;
        n /= 10;
        int tens = n % 10;
        n /= 10;
        int hundreds = n % 10;
        n /= 10;
        int thousands = n % 10;
        
        String[] lines = new String[4];
        for( int i = 0; i < 4; i++ )
        {
            lines[i] = "";

            if( thousands % 2 == 1 )
            {
                lines[i] += "* ";
            }
            else
            {
                lines[i] += ". ";
            }
            thousands /= 2;

            if( hundreds % 2 == 1 )
            {
                lines[i] += "*   ";
            }
            else
            {
                lines[i] += ".   ";
            }
            hundreds /= 2;

            if( tens % 2 == 1 )
            {
                lines[i] += "* ";
            }
            else
            {
                lines[i] += ". ";
            }
            tens /= 2;

            if( ones % 2 == 1 )
            {
                lines[i] += "*";
            }
            else
            {
                lines[i] += ".";
            }
            ones /= 2;
        }

        System.out.println(lines[3]);
        System.out.println(lines[2]);
        System.out.println(lines[1]);
        System.out.print(lines[0]);
    }
}
