import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Map;
// Let roads represent nodes with an id number and order
// Each node will have adjacent nodes
// We want to create a reversed edge graph as well
// Run DFS on reversed edge graph first to find trapped roads
// We need to track nodes that were not reached during the DFS
// Return result, in order
// Then run DFS on original graph to find unreachable road
// Need to print trapped before unreachable

// How do we store the nodes and edges?
// No, we need a Node class implementing a comparable for position, so we know in which order to print
// It comes down to how do we store edges? in the same Node class?
// We could create a hashmap of id -> Node

public class cartrouble 
{
    private static class Node implements Comparable<Node>
    {
        int aId;
        int aPosition;
        ArrayList<Integer> adjacencyList = new ArrayList<>();

        public Node(int pId, int pPosition)
        {
            aId = pId;
            aPosition = pPosition;
        }

        public Node(Node pNode)
        {
            aId = pNode.aId;
            aPosition = pNode.aPosition;
        }

        public void addEdge(int pAdjacent)
        {
            adjacencyList.add(pAdjacent);
        }

        public int compareTo(Node pNode)
        {
            return aPosition - pNode.aPosition;
        }

       
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int numStreets = s.nextInt();
        HashMap<Integer, Node> roads = new HashMap<>();
        HashMap<Integer, Node> reverse = new HashMap<>();
        TreeSet<Node> notVisited = new TreeSet<>();
        TreeSet<Node> trapped = new TreeSet<>();
        for( int i = 0; i < numStreets; i++ )
        {
            int id = s.nextInt();
            int numEdges = s.nextInt();
            Node road = new Node(id, i);
            roads.put(id, road);
            Node copy = new Node(road);
            reverse.put(id, copy);
            notVisited.add(road);
            trapped.add(copy);
            for( int j = 0; j < numEdges; j++ )
            {
                int edgeId = s.nextInt();
                roads.get(id).addEdge(edgeId);

                
            }
        }
        for( Map.Entry<Integer, Node> entry : roads.entrySet() )
        {
            Node current = entry.getValue();
            for( Integer adjacent : current.adjacencyList )
            {
                reverse.get(adjacent).addEdge(current.aId);
            }
        }

        // DFS(reverse.get(0), trapped, reverse);
        // DFS(roads.get(0), notVisited, roads);
        DFSRecursive(reverse.get(0), trapped, reverse);
        DFSRecursive(roads.get(0), notVisited, roads);
        if( trapped.isEmpty() && notVisited.isEmpty() )
        {
            System.out.print("NO PROBLEMS");
        }
        for( Node node : trapped )
        {
            System.out.println("TRAPPED " + node.aId);
        }
        for( Node node : notVisited )
        {
            System.out.println("UNREACHABLE " + node.aId);
        }
    }

    public static void DFS(Node pNode, TreeSet<Node> pNotVisited, HashMap<Integer, Node> pRoads)
    {
        Stack<Node> stack = new Stack<>();
        stack.push(pNode);
        while( !stack.isEmpty() )
        {
            Node current = stack.pop();
            if( pNotVisited.contains(current) )
            {
                pNotVisited.remove(current);
                for( int edge : current.adjacencyList )
                {
                    stack.push(pRoads.get(edge));
                }
            }
        }
    }

    public static void DFSRecursive(Node pNode, TreeSet<Node> pNotVisited, HashMap<Integer, Node> pRoads)
    {
        if( pNotVisited.contains(pNode) )
        {
            pNotVisited.remove(pNode);
            for( int edge : pNode.adjacencyList )
            {
                DFSRecursive(pRoads.get(edge), pNotVisited, pRoads);
            }
        }
    }
}
