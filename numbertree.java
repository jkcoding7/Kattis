import java.util.Scanner;

public class numbertree
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int H = s.nextInt();
        long totalNodes = (long) Math.pow(2, H + 1);
        char[] path = s.nextLine().trim().toCharArray();
        long index = 1;
        for ( char c : path )
        {
            index *= 2;
            
            if (c == 'R')
            {
                index++;
            }
        }
        System.out.print(totalNodes - index);
        s.close();
    }
}