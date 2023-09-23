import java.util.Scanner;

public class oddities {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTests = s.nextInt();
        
        for (int i = 0; i < numTests; i++) {
            int testCase = s.nextInt();
            
            if (testCase % 2 == 0) {
                System.out.println(testCase + " is even");
            }
            else {
                System.out.println(testCase + " is odd");
            }
        }
    }
}
