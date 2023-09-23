import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class t9spelling
{
    public static void main(String[] args) 
    {
        Map<Character, String> keypad = new HashMap<>();
        keypad.put('a', "2");
        keypad.put('b', "22");
        keypad.put('c', "222");
        keypad.put('d', "3");
        keypad.put('e', "33");
        keypad.put('f', "333");
        keypad.put('g', "4");
        keypad.put('h', "44");
        keypad.put('i', "444");
        keypad.put('j', "5");
        keypad.put('k', "55");
        keypad.put('l', "555");
        keypad.put('m', "6");
        keypad.put('n', "66");
        keypad.put('o', "666");
        keypad.put('p', "7");
        keypad.put('q', "77");
        keypad.put('r', "777");
        keypad.put('s', "7777");
        keypad.put('t', "8");
        keypad.put('u', "88");
        keypad.put('v', "888");
        keypad.put('w', "9");
        keypad.put('x', "99");
        keypad.put('y', "999");
        keypad.put('z', "9999");
        keypad.put(' ', "0");

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();

        for (int i = 1; i < N + 1; i++)
        {
            String phrase = s.nextLine();
            String output = "";

            for (int j = 0; j < phrase.length(); j++)
            {
                char currentLetter = phrase.charAt(j);

                if (j != 0 && output.charAt(output.length() - 1) == keypad.get(currentLetter).charAt(0))
                {
                    output += " ";
                }

                output += keypad.get(currentLetter);
            }

            System.out.println("Case #" + i + ": " + output);
        }

        s.close();
    }
}