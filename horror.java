import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class horror 
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numMovies = s.nextInt();
        int numHorror = s.nextInt();
        int numComparisons = s.nextInt();
        HashMap<Integer, Node> movies = new HashMap<>();
        for( int i = 0; i < numMovies; i++ )
        {
            movies.put(i, new Node(i));
        }
        for( int i = 0; i < numHorror; i++ )
        {
            int horrorMovie = s.nextInt();
            movies.get(horrorMovie).testHorrorIndex(0);          
        }
        for( int i = 0; i < numComparisons; i++ )
        {
            Node movieA = movies.get(s.nextInt());
            Node movieB = movies.get(s.nextInt());
            movieB.addSimilarMovie(movieA);
            if( movieA.aHorrorIndex != movieB.aHorrorIndex )
            {
                if( movieA.aHorrorIndex < movieB.aHorrorIndex )
                {
                    movieB.testHorrorIndex(movieA.aHorrorIndex + 1);
                }
                else
                {
                    movieA.testHorrorIndex(movieB.aHorrorIndex + 1);
                }
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        for (Node movie : movies.values()) {
            if (movie.aHorrorIndex == 0) { // If it's a horror movie
                BFS(movies, movie, visited);
            }
        }

        TreeSet<Node> byHorrorIndex = new TreeSet<>();
        for( int i = 0; i < numMovies; i++ )
        {
            byHorrorIndex.add(movies.get(i));
        }
        System.out.print(byHorrorIndex.last().aId);
    }
    
    public static void BFS(HashMap<Integer, Node> pMovies, Node pMovie, HashSet<Integer> pVisited)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(pMovie);
        pVisited.add(pMovie.aId);
        while( !queue.isEmpty() )
        {
            Node movie = queue.remove();
            for( int id : movie.aSimilar )
            {
                if( !pVisited.contains(id) )
                {
                    pVisited.add(id);
                    queue.add(pMovies.get(id));
                    pMovies.get(id).testHorrorIndex(movie.aHorrorIndex + 1);
                }
            }
        }

    }
    
    // First intuition: bfs? 
    // If A is on horror list , so A = 0, and A B, then B = 1 ->
    // Suppose B C, then C = 2, but then suppose A C, then  C = 1? Yes
    // Data structure: Create nodes with an id and horrorIndex
    // Set horrorIndex of nodes that are on horror list to 0, all others to infinity
    // Process comparisons: compare horrorIndexes.
    // If both are infinity, both remain infinity
    // Else if both are zero, both remain zero
    // else, at least one of the two are not equal to zero nor infinity
    // then, the movie with the smaller horrorIndex stays the same
    // the other movie's horror index is the smaller + 1, but only if smaller + 1 < current horrorIndex

    // Problem: Suppose A has index = 3 and A B, i.e. A and B are similar, then B has index = 4
    //          But if we have C with index = 0, and it is known later A C, then A's horror index is updated to = 1
    //          However, since A and B is similar, B's horror index should be updated to = 2
    //          We need a way to update indicies of past similar horror movies
    // Solution: Build an adjacency list?
    // Use DFS to update all similar movies once an index is updated 
    static class Node implements Comparable<Node>
    {
        int aId;
        int aHorrorIndex = Integer.MAX_VALUE;
        HashSet<Integer> aSimilar = new HashSet<>();

        public Node(int pId)
        {
            aId = pId;
        }

        public int compareTo(Node pNode)
        {
            if( aHorrorIndex == pNode.aHorrorIndex )
            {
                return pNode.aId - aId;
            }
            return aHorrorIndex - pNode.aHorrorIndex;
        }

        public void testHorrorIndex(int pRating)
        {
            aHorrorIndex = Math.min(aHorrorIndex, pRating);
        }

        public void addSimilarMovie(Node pMovie)
        {
            aSimilar.add(pMovie.aId);
            pMovie.aSimilar.add(this.aId);
        }
    }
}
