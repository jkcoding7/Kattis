import java.util.Scanner;

public class timebomb
{
   public static void main(String[] args) 
    {
        String[] validDigits = {"**** ** ** ****", "  *  *  *  *  *", 
                                "***  *****  ***", "***  ****  ****", 
                                "* ** ****  *  *", "****  ***  ****", 
                                "****  **** ****", "***  *  *  *  *", 
                                "**** ***** ****", "**** ****  ****"};
        
        Scanner s = new Scanner(System.in);
        String[] code = new String[5];
        
        for (int i = 0; i < 5; i++) 
        {
            code[i] = s.nextLine();
        }

        int numDigits = (code[0].length() + 1) / 4;
        String[] codeDigits = new String[numDigits];

        for (int i = 0; i < numDigits; i++) 
        {
            codeDigits[i] = "";
            
            for (int j = 0; j < 5; j++) 
            {
                codeDigits[i] += code[j].substring(i * 4, i * 4 + 3);
            }
        }
        
        String codeInNumeric = "";
        boolean validDigitFound;

        for (int i = 0; i < numDigits; i++) 
        {
            validDigitFound = false;
            for (int j = 0; j < validDigits.length; j++) 
            {
                if (codeDigits[i].equals(validDigits[j]))
                {
                    codeInNumeric += j;
                    validDigitFound = true;
                }
            }

            if (validDigitFound == false) 
            {
                System.out.println("BOOM!!");
                System.exit(0);
            }
        }
        
        if (Integer.parseInt(codeInNumeric) % 6 == 0) 
        {
            System.out.println("BEER!!");
        }
        else
        {
            System.out.println("BOOM!!");
        }
        
        s.close();
    }
}
