import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class virtualfriends
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();
        StringBuilder result = new StringBuilder();
        for( int i = 0; i < num; i++ )
        {
            int F = s.nextInt();
            s.nextLine();
            HashMap<String, HashSet<String>> network = new HashMap<>();
            HashMap<String, String> parent = new HashMap<>();
            for( int j = 0; j < F; j++ )
            {
                String friend1 = s.next();
                String friend2 = s.next();
                s.nextLine();
                if( !parent.containsKey(friend1) && !parent.containsKey(friend2) )
                {
                    parent.put(friend1, friend1);
                    parent.put(friend2, friend1);
                    network.put(friend1, new HashSet<String>());
                    network.get(friend1).add(friend1);
                    network.get(friend1).add(friend2);
                }
                else if( !parent.containsKey(friend1) )
                {
                    parent.put(friend1, parent.get(friend2));
                    network.get(parent.get(friend1)).add(friend1);
                }
                else if( !parent.containsKey(friend2) )
                {
                    parent.put(friend2, parent.get(friend1));
                    network.get(parent.get(friend2)).add(friend2);
                }
                else if( !parent.get(friend1).equals(parent.get(friend2)) )
                {
                    String prevParent = "";
                    if( network.get(parent.get(friend1)).size() < network.get(parent.get(friend2)).size() )
                    {
                        prevParent = parent.get(friend1);
                        for( String name : network.get(parent.get(friend1)) )
                        {
                            parent.put(name, parent.get(friend2));
                        }
                        network.get(parent.get(friend2)).addAll(network.get(prevParent));
                    }
                    else
                    {
                        prevParent = parent.get(friend2);
                        for( String name : network.get(parent.get(friend2)) )
                        {
                            parent.put(name, parent.get(friend1));
                        }
                        network.get(parent.get(friend1)).addAll(network.get(prevParent));
                    }
                    network.remove(prevParent);
                }
                result.append(network.get(parent.get(friend1)).size() + "\n");
            }
        }
        System.out.print(result);
    }
}