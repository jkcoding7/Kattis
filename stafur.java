import java.io.BufferedReader;
import java.io.InputStreamReader;

public class stafur 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        char x = s.readLine().charAt(0);
        if( x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U' )
        {
            System.out.print("Jebb");
        }
        else if( x == 'Y' )
        {
            System.out.print("Kannski");
        }
        else
        {
            System.out.print("Neibb");
        }
    }
}
