import java.util.Scanner;

public class erase {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numOverwrites = s.nextInt();
        s.nextLine();
        String file1 = s.nextLine();
        String file2 = s.nextLine();
        
        if (numOverwrites % 2 == 0) {
            for (int i = 0; i < file1.length(); i++) {
                if (file1.charAt(i) != file2.charAt(i)) {
                    System.out.println("Deletion failed");
                    System.exit(0);
                }
            }
        }
        else {
            for (int i = 0; i < file1.length(); i++) {
                if (file1.charAt(i) == file2.charAt(i)) {
                    System.out.println("Deletion failed");
                    System.exit(0);
                }
            }
        }
        
        System.out.println("Deletion succeeded");
        s.close();
    }
}