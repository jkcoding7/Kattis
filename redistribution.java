import java.util.Scanner;
import java.util.Arrays;

public class redistribution 
{
    static class Room implements Comparable<Room>
    {
        int aRoomNumber;
        int aNumStudents;

        public Room(int pRoomNumber, int pNumStudents)
        {
            aRoomNumber = pRoomNumber + 1;
            aNumStudents = pNumStudents;
        }

        public int compareTo(Room pRoom)
        {
            return pRoom.aNumStudents - aNumStudents;
        }
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int numRooms = s.nextInt();
        Room[] rooms = new Room[numRooms];
        for( int i = 0; i < numRooms; i++ )
        {
            rooms[i] = new Room(i, s.nextInt());
        }
        Arrays.sort(rooms);
        int maxStudents = rooms[0].aNumStudents;
        int count = 0;
        for( int i = 1; i < numRooms; i++ )
        {
            count += rooms[i].aNumStudents;
        }
        if( maxStudents > count )
        {
            System.out.print("impossible");
        }
        else
        {
            for( int i = 0; i < numRooms; i++ )
            {
                System.out.print(rooms[i].aRoomNumber + " ");
            }
        }
    }    
}
