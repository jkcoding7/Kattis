import java.util.Scanner;

public class guess
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int max = 1000;
        int min = 1;
        int guess = (max + min) / 2;
        System.out.println(guess);
        String response = s.next();
        while( !response.equals("correct") )
        {
            if( response.equals("lower") )
            {
                max = guess;
                guess = (max + min) / 2;
            }
            else
            {
                min = guess;
                guess = (max + min + 1) / 2;
            }
            System.out.println(guess);
            response = s.next();
        }
    }
}