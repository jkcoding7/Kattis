import java.util.Scanner;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class jurassicjigsaw 
{
    private static class DNA
    {
        String aSequence;
        int aPosition;
        static int length;

        public DNA(String pSequence, int pPosition)
        {
            aSequence = pSequence;
            aPosition = pPosition;
            length = pSequence.length();
        }

        public int diff(DNA pDNA)
        {
            int result = 0;
            for(int i = 0; i < length; i++ )
            {
                if( aSequence.charAt(i) != pDNA.aSequence.charAt(i) )
                {
                    result++;
                }
            }
            return result;
        }
    }

    private static class Edge implements Comparable<Edge>
    {
        DNA aFrom;
        DNA aTo;
        int aDiff;

        public Edge(DNA pFrom, DNA pTo, int pDiff)
        {
            aFrom = pFrom;
            aTo = pTo;
            aDiff = pDiff;
        }

        public int compareTo(Edge pEdge)
        {
            return aDiff - pEdge.aDiff;
        }
    }
    public static void main(String[] args)
    {
        // Find the smallest possible sum of weights of all edges -> given nodes, construct the smallest sum of weights of all edges
        // Weight of an edge is the number of positions at which the letters two nodes are different
        // Result: a single int representing the smallest sum of weights of all edges, followed by
        // the n-1 edges in the graph producing the result above

        // Approach: Use prim's algorithm to find the MST given a set of nodes
        // 1. create a node class
        // 2. create a set S containing nodes that are in MST, and a set Q containing nodes not yet included
        // 3. create a set E containing the edges that make up the MST
        // 4. run prim's algorithm. Need to find minimum weighted edge connecting any node in S to any node in Q
        // We have a priority queue of the next edge to be added. we still want to add the new DNA to S while removing it from Q
        Scanner s = new Scanner(System.in);
        int numNodes = s.nextInt();
        s.nextLine();
        DNA[] nodes = new DNA[numNodes];
        for( int i = 0; i < numNodes; i++ )
        {
            String sequence = s.nextLine();
            nodes[i] = new DNA(sequence, i);
        }
        HashSet<DNA> included = new HashSet<>();
        included.add(nodes[0]);
        HashSet<DNA> excluded = new HashSet<>();
        for( int i = 1; i < numNodes; i++ )
        {
            excluded.add(nodes[i]);
        }
        HashSet<int[]> edges = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for( DNA out : excluded )
        {
            queue.add(new Edge(nodes[0], out, nodes[0].diff(out)));
        }
        int result = 0;
        while( !excluded.isEmpty() )
        {
            Edge minEdge = queue.poll();
            if( included.contains(minEdge.aTo) )
            {
                continue;
            }
            included.add(minEdge.aTo);
            excluded.remove(minEdge.aTo);
            int[] edge = {minEdge.aFrom.aPosition, minEdge.aTo.aPosition};
            edges.add(edge);
            result += minEdge.aDiff;
            for( DNA out : excluded )
            {
                queue.add(new Edge(minEdge.aTo, out, minEdge.aTo.diff(out)));
            }
        }
        System.out.println(result);
        for( int[] edge : edges )
        {
            System.out.println(edge[0] + " " + edge[1]);
        }
    }    
}
