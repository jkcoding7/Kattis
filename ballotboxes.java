import java.util.Scanner;
import java.util.PriorityQueue;

public class ballotboxes
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int B = s.nextInt();
        StringBuilder result = new StringBuilder();
        PriorityQueue<City> cities = new PriorityQueue<>();
        while( N != -1 )
        {
            for( int i = 0; i < N; i++ )
            {
                cities.add(new City(s.nextInt()));
            }
            City mostPopulated;
            while( B-- > N )
            {
                mostPopulated = cities.poll();
                mostPopulated.addBallot();
                cities.add(mostPopulated); 
            }
            result.append(cities.peek().ratio).append("\n");
            N = s.nextInt();
            B = s.nextInt();
            cities.clear();
        }
        System.out.print(result);
    }

    static class City implements Comparable<City>
    {
        int population;
        int ballots = 1;
        int ratio;

        public City(int pPopulation)
        {
            population = pPopulation;
            ratio = pPopulation;
        }

        public void addBallot()
        {
            ratio = (int) Math.ceil((double) population / ++ballots);
        }

        public int compareTo(City pCity)
        {
            return pCity.ratio - ratio;
        }
    }
}