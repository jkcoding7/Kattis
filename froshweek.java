import java.util.Scanner;

public class froshweek
{
    static long swaps = 0;
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        int[] students = new int[n];
        for( int i = 0; i < n; i++ )
        {
            students[i] = s.nextInt();
            s.nextLine();
        }
        mergeSort(students, 0, students.length - 1);
        System.out.print(swaps);
    }
    
    public static void mergeSort(int[] pStudents, int pLeft, int pRight)
    {
        if( pLeft < pRight )
        {
            int mid = (pLeft + pRight) / 2;
            mergeSort(pStudents, pLeft, mid);
            mergeSort(pStudents, mid + 1, pRight);
            merge(pStudents, pLeft, mid, pRight);
        }
    }
    
    public static void merge(int[] pStudents, int pLeft, int pMid, int pRight)
    {
        int leftLength = pMid - pLeft + 1;
        int rightLength = pRight - pMid;
        
        int[] leftHalf = new int[leftLength];
        int[] rightHalf = new int[rightLength];
        
        for( int i = 0; i < leftLength; i++ )
        {
            leftHalf[i] = pStudents[pLeft + i];
        }
        for( int i = 0; i < rightLength; i++ )
        {
            rightHalf[i] = pStudents[pMid + i + 1];
        }
        
        int i, j, k;
        i = j = 0;
        k = pLeft;
        
        while( i < leftLength && j < rightLength )
        {
            if( leftHalf[i] < rightHalf[j] )
            {
                pStudents[k++] = leftHalf[i++];
            }
            else
            {
                pStudents[k++] = rightHalf[j++];
                swaps += leftLength - i;
            }
        }
        while( i < leftLength )
        {
            pStudents[k++] = leftHalf[i++];
        }
        while( j < rightLength )
        {
            pStudents[k++] = rightHalf[j++];
        }
    }
}