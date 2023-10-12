import java.util.Scanner;

public class pyramids 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int level = 0;
        int blocks = 1;
        while( N - (blocks * blocks) >= 0 )
        {
            N = N - (blocks * blocks);
            level++;
            blocks += 2;
        }
        System.out.print(level);
    }
}
