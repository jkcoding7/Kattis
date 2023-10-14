import java.util.Scanner;
import java.util.Arrays;

public class natrij 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String[] c = s.nextLine().split(":");
        String[] e = s.nextLine().split(":");
        int[] current = new int[3];
        int[] explosion = new int[3];
        int[] result = new int[3];
        for( int i = 0; i < 3; i++ )
        {
            current[i] = Integer.parseInt(c[i]);
            explosion[i] = Integer.parseInt(e[i]);

        }

        int currentInSeconds = current[0] * 3600 + current[1] * 60 + current[2];
        int explosionInSeconds = explosion[0] * 3600 + explosion[1] * 60 + explosion[2];
        if( currentInSeconds < explosionInSeconds )
        {
            int difference = explosionInSeconds - currentInSeconds;
            result[0] = difference / 3600;
            difference -= result[0] * 3600;
            result[1] = difference / 60;
            difference -= result[1] * 60;
            result[2] = difference;
        }
        else
        {
            explosionInSeconds += 24 * 3600;
            int difference = explosionInSeconds - currentInSeconds;
            result[0] = difference / 3600;
            difference -= result[0] * 3600;
            result[1] = difference / 60;
            difference -= result[1] * 60;
            result[2] = difference;
        }
        String format = String.format("%02d:%02d:%02d", result[0], result[1], result[2]);
        System.out.print(format);
    }
}
