import java.util.Scanner;
import java.util.HashSet;

public class engineeringenglish {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        while(s.hasNextLine())
        {
            String[] line = s.nextLine().toLowerCase().split(" ");
            for(String curr : line)
            {
                if(!hs.contains(curr))
                {
                    hs.add(curr);
                    System.out.print(curr + " ");
                }
                else
                {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
