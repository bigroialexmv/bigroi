package org.alexkurets.homework3;

public class BubbleArraySorter implements IArraySorter{

    private int countOfLoop;

    @Override
    public void sort(int[] arr, boolean order) {
        int flag =0;

        for(int i=0;i<(arr.length-1);i++)
        {
            flag=0;
            for(int j=0;j<(arr.length-1-i);j++)
            {
                if(order==true)
                {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag++;
                    }
                }
                else
                {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag++;
                    }
                }
            }

            countOfLoop++;
            if(flag==0)
                break;
            else
                flag=0;
        }
    }

    public int getCountOfLoop() {
        return countOfLoop;
    }

    public void setCountOfLoop(int countOfLoop) {
        this.countOfLoop = countOfLoop;
    }
}
