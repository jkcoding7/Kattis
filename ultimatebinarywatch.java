import java.util.Scanner;

public class ultimatebinarywatch 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ones = n % 10;
        n /= 10;
        int tens = n % 10;
        n /= 10;
        int hundreds = n % 10;
        n /= 10;
        int thousands = n % 10;
        StringBuilder zero = new StringBuilder("         ");
        StringBuilder one = new StringBuilder("         ");
        StringBuilder two = new StringBuilder("         ");
        StringBuilder three = new StringBuilder("         ");
        
        if( thousands % 2 == 1 )
        {
            zero.setCharAt(0, '*');
        }
        else
        {
            zero.setCharAt(0, '.');
        }
        thousands /= 2;
        if( thousands % 2 == 1 )
        {
            one.setCharAt(0, '*');
        }
        else
        {
            one.setCharAt(0, '.');
        }
        thousands /= 2;
        if( thousands % 2 == 1 )
        {
            two.setCharAt(0, '*');
        }
        else
        {
            two.setCharAt(0, '.');
        }
        thousands /= 2;
        if( thousands % 2 == 1 )
        {
            three.setCharAt(0, '*');
        }
        else
        {
            three.setCharAt(0, '.');
        }
        
        if( hundreds % 2 == 1 )
        {
            zero.setCharAt(2, '*');
        }
        else
        {
            zero.setCharAt(2, '.');
        }
        hundreds /= 2;
        if( hundreds % 2 == 1 )
        {
            one.setCharAt(2, '*');
        }
        else
        {
            one.setCharAt(2, '.');
        }
        hundreds /= 2;
        if( hundreds % 2 == 1 )
        {
            two.setCharAt(2, '*');
        }
        else
        {
            two.setCharAt(2, '.');
        }
        hundreds /= 2;
        if( hundreds % 2 == 1 )
        {
            three.setCharAt(2, '*');
        }
        else
        {
            three.setCharAt(2, '.');
        }

        if( tens % 2 == 1 )
        {
            zero.setCharAt(6, '*');
        }
        else
        {
            zero.setCharAt(6, '.');
        }
        tens /= 2;
        if( tens % 2 == 1 )
        {
            one.setCharAt(6, '*');
        }
        else
        {
            one.setCharAt(6, '.');
        }
        tens /= 2;
        if( tens % 2 == 1 )
        {
            two.setCharAt(6, '*');
        }
        else
        {
            two.setCharAt(6, '.');
        }
        tens /= 2;
        if( tens % 2 == 1 )
        {
            three.setCharAt(6, '*');
        }
        else
        {
            three.setCharAt(6, '.');
        }

        if( ones % 2 == 1 )
        {
            zero.setCharAt(8, '*');
        }
        else
        {
            zero.setCharAt(8, '.');
        }
        ones /= 2;
        if( ones % 2 == 1 )
        {
            one.setCharAt(8, '*');
        }
        else
        {
            one.setCharAt(8, '.');
        }
        ones /= 2;
        if( ones % 2 == 1 )
        {
            two.setCharAt(8, '*');
        }
        else
        {
            two.setCharAt(8, '.');
        }
        ones /= 2;
        if( ones % 2 == 1 )
        {
            three.setCharAt(8, '*');
        }
        else
        {
            three.setCharAt(8, '.');
        }

        System.out.println(three);
        System.out.println(two);
        System.out.println(one);
        System.out.print(zero);

    }
}
