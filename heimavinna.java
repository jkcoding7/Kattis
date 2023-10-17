import java.util.Scanner;

public class heimavinna 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String[] problems = s.nextLine().split(";");
        int result = 0;
        String[] compute = new String[2];
        for( int i = 0; i < problems.length; i++ )
        {
            if( !problems[i].contains("-") )
            {
                result++;
                continue;
            }
            else
            {
                compute = problems[i].split("-");
                int a = Integer.parseInt(compute[0]);
                int b = Integer.parseInt(compute[1]);
                int c = b - a + 1;
                result += c;
            }
        }
        System.out.print(result);
    }    
}
