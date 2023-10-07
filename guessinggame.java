    import java.util.Scanner;

    public class guessinggame 
    {
        public static void main(String[] args)
        {
            Scanner s = new Scanner(System.in);
            int min = 0;
            int max = 11;
            int guess;
            String[] response = new String[2];
            while( true )
            {
                guess = s.nextInt();
                s.nextLine();
                if( guess == 0 )
                {
                    break;
                }
                response = s.nextLine().split(" ");
                if( response[1].equals("on") )
                {
                    System.out.println(min < guess && max > guess ? "Stan may be honest" : "Stan is dishonest" );
                    min = 0;
                    max = 11;
                    continue;
                }
                else if( response[1].equals("high") )
                {
                    max = Math.min(max, guess);
                }
                else
                {
                    min = Math.max(min, guess);
                }
            }
        }
    }
