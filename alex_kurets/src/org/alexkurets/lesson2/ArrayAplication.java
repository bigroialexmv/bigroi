package org.alexkurets.lesson2;

public class ArrayAplication {
	
	public static void main(String [] args){
		//int [] a = new int[3];
		//int [] b = new int[]{1,2,3};//Variant 1
		
		//String [] arrStr1 = new String[2];
		
		int [] arr1={0,1,2,3,4,5,6,7,8,-9};//Variant 2
		viewArray(arr1);
		swap(arr1,0,arr1.length-1);
		viewArray(arr1);
		
		System.out.println("Max value in arr1 is:"+max(arr1));
		System.out.println("Index of searching element is:"+search(arr1,5));
		
		
	}
	
	
	private static void swap(int [] x, int i, int j){
		int temp;
		
		if(i>(x.length-1) || j>(x.length-1))
		{
			System.out.println("Array haven't changed.Change parametrs i or j!");
			return;
		}
		
		temp=x[i];
		x[i]=x[j];
		x[j]=temp;
	}
	
	private static int max(int[] arr){
		int temp=arr[0];
		
		for(int i=1;i<1;i++)
		{
			System.out.println("Step");
			if(arr[i]>temp)
				temp=arr[i];
		}
		
		return temp;
	}
	
	private static int search(int[]arr, int element){
		int index=-1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==element)
			{
				index=i;
				break;
			}
				
		}
		return index;
	}
	
	private static void viewArray(int[] arr){
		System.out.println("Content of array is:");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	
	private static void binarySearch(int [] a, int x)
	{
		int index=0;
		
		int p = 0;
		int q = a.length;
		int i = a.length/2;
	}
}
