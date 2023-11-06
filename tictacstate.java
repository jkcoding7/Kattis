import java.util.Scanner;

public class tictacstate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTests = s.nextInt();
        int[] winPatterns = {7, 56, 448, 73, 146, 292, 273, 84}; // Corrected win patterns based on 3x3 grid

        while (numTests-- > 0) {
            int state = Integer.parseInt(s.next(), 8);
            int played = state & 0b111111111;  // Extract played positions
            int xPlayed = (state >> 9) & 0b111111111; // Extract X played positions
            int oPlayed = played & (~xPlayed); // Extract O played positions

            boolean xWins = false, oWins = false;
            for (int pattern : winPatterns) {
                if ((xPlayed & pattern) == pattern) {
                    xWins = true;
                }
                if ((oPlayed & pattern) == pattern) {
                    oWins = true;
                }
            }

            if (xWins) {
                System.out.println("X wins");
            } else if (oWins) {
                System.out.println("O wins");
            } else if (played == 0b111111111) { // All positions are played
                System.out.println("Cat's");
            } else {
                System.out.println("In progress");
            }
        }
        s.close();
    }
}
