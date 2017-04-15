package org.alexkurets.homework3;


public class Main {

    public static void main(String[] args) {
        int [] arr1 = {1,2,10,5,7,9};
        BubbleArraySorter obj1 =new BubbleArraySorter();
        obj1.sort(arr1,true);

        for(int i=0;i<arr1.length;i++)
        {
            System.out.print(" "+arr1[i]);
        }
        System.out.println();

        //System.out.println("obj1.getCountOfLoop() = " + obj1.getCountOfLoop());

        int [] arr2 = {1,2,3,3,3,4,5,6,100,200,100};
        System.out.println("searching index: "+ ArrayUtil.BinarySearch(arr2,100));


        char[] charArr1 = "Good evening my pretty friend!".toCharArray();
        char[] charArr2 = "Good evening my pretty friend".toCharArray();
        System.out.println(StringUtil.searchSubstring(charArr1,charArr2));
        
        
        
        TimeMesaure timer = new TimeMesaure();
        for(int i=0;i<1000000;i++)
        {
        	
        }
        System.out.println(timer.getPasseMillis());
        
        System.out.println("-------------------------------------");
        
        int arr[] = RandomArray.getRandomArray(10);
        
        
        for(int i=0;i<arr.length;i++)
        	System.out.println(arr[i]);
    }
}
