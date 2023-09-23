import java.util.Scanner;

public class sorttwonumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        
        if (a < b) {
            System.out.print(a + " " + b);
        }
        else {
            System.out.print(b + " " + a);
        }
    }
}