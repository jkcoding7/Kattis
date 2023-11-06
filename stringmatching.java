import java.util.Scanner;

public class stringmatching {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while( s.hasNextLine() )
        {
            char[] pattern = s.nextLine().toCharArray();
            String line = s.nextLine();
            char[] text = new char[line.length() + 1];
            for( int i = 1; i < text.length; i++ )
            {
                text[i] = line.charAt(i - 1);
            }
            int patternLength = pattern.length;
            int textLength = text.length;
            
            int len = 0;
            int i = 1;
            int[] pi = new int[patternLength];
            pi[0] = 0;

            while( i < patternLength )
            {
                if( pattern[i] == pattern[len] )
                {
                    len++;
                    pi[i] = len;
                    i++;
                }
                else
                {
                    if( len != 0 )
                    {
                        len = pi[len - 1];
                    }
                    else
                    {
                        pi[i] = len;
                        i++;
                    }
                }
            }

            i = 0;
            int j = 0;
            while ((textLength - i) >= (patternLength - j)) {
                if (pattern[j] == text[i]) {
                    j++;
                    i++;
                }
                if (j == patternLength) {
                    System.out.print((i - j - 1 + " "));
                    j = pi[j - 1];
                }
     
                // mismatch after j matches
                else if (i < textLength
                         && pattern[j] != text[i]) {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0)
                        j = pi[j - 1];
                    else
                        i = i + 1;
                }
            }
            System.out.println();
        }
    }
}
