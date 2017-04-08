package org.alexkurets.homework2;

public class SpecClass2 {
    public static int isSorted(int[] arr)
    {
        if(arr[0]<=arr[1])
        {
            for(int i=1;i<arr.length-1;i++)
            {
                if(arr[i]>arr[i+1])
                    return 0;
            }
            return 1;
        }
        else
        {
            for(int i=1;i<arr.length-1;i++)
            {
                if(arr[i]<arr[i+1])
                    return 0;
            }
            return -1;
        }
    }
}
