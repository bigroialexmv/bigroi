package org.alexkurets.homework2;

public class SpecClass1 {
    public static int calcEvenOddNum(int[]arr)
    {
        int sumEven = 0;
        int sumOdd = 0;

        for(int i=0; i<arr.length;i++)
        {
            if(arr[i]%2==0)
                sumEven+=arr[i];
            else
                sumOdd+=arr[i];
        }

        return sumEven-sumOdd;
    }

    public static void viewArr(int[]arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
