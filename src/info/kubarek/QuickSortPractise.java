package info.kubarek;

import java.util.Arrays;

public class QuickSortPractise
{

    public static void main(String[] args)
    {
        int[] arr = new int[] { 8, 2, 4, 1, 9, 6, 5, 3, 10, 0, 10, 9, 1, -1, 0, 3 };
        System.out.println("arr.length = " + arr.length);
        System.out.println("Before: " + Arrays.toString(arr));
        
        quick(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
    }
    
    public static void quick(int[] A, int lo, int hi)
    {
        if (A.length == 0)
            return;
        
        if (lo >= hi)
            return;
        
        int pivot = hi;
        int val = A[pivot];
        for (int i = lo; i < pivot; i++)
            if (A[i] >= val)
            {
                int tmp = A[i];
                A[i] = A[pivot];
                A[pivot] = tmp;
            }
        
        System.out.println("quick: " + Arrays.toString(A));
        
        int p = lo + ((hi - lo) / 2);
        quick(A, lo, p);
        quick(A, p + 1, hi);
    }
}
