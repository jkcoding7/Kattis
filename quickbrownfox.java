import java.util.Scanner;
import java.util.ArrayList;

public class quickbrownfox {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numPhrases = s.nextInt();
        s.nextLine();
        
        for (int i = 0; i < numPhrases; i++) {
            ArrayList<Character> letters = new ArrayList<>();;
            String phrase = s.nextLine().toLowerCase();
            
            for (int j = 0; j < 26; j++) {
                if (!phrase.contains("" + ((char) ('a' + j)))) {
                    letters.add((char) ('a' + j));
                }
            }
            
            if (letters.isEmpty()) {
                System.out.println("pangram");
                continue;
            }
            else {
                System.out.print("missing ");
                for (char c : letters) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        s.close();
    }
}