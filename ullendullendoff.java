import java.util.Scanner;

public class ullendullendoff 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int numFriends = s.nextInt();
        s.nextLine();
        String[] friends = s.nextLine().split(" ");
        int position = 13 % numFriends;
        if( numFriends == 1 )
        {
            System.out.println(friends[0]);
            
        }
        else if( numFriends < 13 )
        {
            System.out.println(friends[position - 1]);
        }
        else
        {
            System.out.println(friends[12]);
        }
    }    
}
