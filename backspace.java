import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class backspace
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        List<Character> result = new ArrayList<>();
        for( int i = 0; i < text.length(); i++ )
        {
            if( text.charAt(i) != '<' )
            {
                result.add(text.charAt(i));
            }
            else
            {
                result.remove(result.size() - 1);
            }
        }
        System.out.print(result.toString().replaceAll("[\\s\\[\\],]", ""));
        s.close();
    }
}