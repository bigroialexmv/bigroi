package org.alexkurets.homework3;

public class ArrayUtil {
    public static int BinarySearch(int [] arr, int index)
    {
        int l=-1;
        int r=arr.length;
        int m=0;

        while(l<r-1)
        {
            m=(l+r)/2;
            if(arr[m]<index)
                l=m;
            else
                r=m;

        }
        return r;
    }
}
