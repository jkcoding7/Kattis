import java.io.BufferedReader;
import java.io.InputStreamReader;

public class quiteaproblem 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String line = s.readLine();
        boolean problem;
        while( line != null )
        {
            String[] words = line.toLowerCase().split(" ");
            problem = false;
            for( int i = 0; i < words.length; i++ )
            {
                if( words[i].contains("problem") )
                {
                    problem = true;
                    break;
                }
            }
            System.out.println(problem ? "yes" : "no");
            line = s.readLine();
        }
        s.close();
    }
}
