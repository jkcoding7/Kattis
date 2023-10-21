import java.util.Scanner;

public class upprodun 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int students = s.nextInt();
        int minimum = students / rows;
        int leftover = students % rows;
        for( int i = 0; i < rows; i++ )
        {
            for( int j = 0; j < minimum; j++ )
            {
                System.out.print("*");
            }
            if( leftover > 0 )
            {
                System.out.print("*");
                leftover--;
            }
            if( i != rows -1 )
            {
                System.out.println();
            }
        }
    }
}
