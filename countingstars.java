import java.util.Scanner;

public class countingstars
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int num = 1;
        String result = "";
        while (s.hasNextLine())
        {
            int height = s.nextInt();
            int width = s.nextInt();
            s.nextLine();
            char[][] sky = new char[height + 2][width + 2];
            for ( int row = 1; row < height + 1; row++ )
            {
                String line = s.nextLine();
                for ( int col = 1; col < width + 1; col++)
                {
                    sky[row][col] = line.charAt(col - 1);
                }
            }
            boolean[][] visited = new boolean[height + 2][width + 2];
            int stars = 0;
            for ( int row = 1; row < height + 1; row++ )
            {
                for ( int col = 0; col < width + 1; col++ )
                {
                    if ( sky[row][col] == '-' && !visited[row][col] )
                    {
                        fillStar(sky, visited, row, col);
                        stars++;   
                    }
                }
            }
            result += "Case " + num + ": " + stars + "\n";
            num++;
        }
        System.out.println(result);
        s.close();
    }

    public static void fillStar(char[][] pSky, boolean[][] pVisited, int pRow, int pCol)
    {
        if ( pRow == 0 || pRow == pSky.length - 1 || pCol == 0 || pCol == pSky[0].length - 1 )
        {
            return;
        }
        pVisited[pRow][pCol] = true;
        
        if ( pSky[pRow + 1][pCol] == '-' && !pVisited[pRow + 1][pCol] )
        {
            fillStar(pSky, pVisited, pRow + 1, pCol);
        }
        if ( pSky[pRow - 1][pCol] == '-' && !pVisited[pRow - 1][pCol] )
        {
            fillStar(pSky, pVisited, pRow - 1, pCol);
        }
        if ( pSky[pRow][pCol + 1] == '-' && !pVisited[pRow][pCol + 1] )
        {
            fillStar(pSky, pVisited, pRow, pCol + 1);
        }
        if ( pSky[pRow][pCol - 1] == '-' && !pVisited[pRow][pCol - 1] )
        {
            fillStar(pSky, pVisited, pRow, pCol - 1);
        }
    }
}