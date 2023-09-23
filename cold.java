import java.util.Scanner;

public class cold
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int numDays = s.nextInt();
        int numFreezing = 0;
        
        for (int i = 0; i < numDays; i++) 
        {
            if (s.nextInt() < 0) 
            {
                numFreezing++;
            }
        }
        
        System.out.println(numFreezing);
    }
}