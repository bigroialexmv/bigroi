package org.alexkurets.homework3;

import java.util.Random;

public class RandomArray {
	
	public static int[] getRandomArray(int size)
	{
		int[] arr=new int[size];
		
		Random ran = new Random();
		
		arr[0]=ran.nextInt(200);
		
		for(int i=1;i<size;i++)
		{
			//arr[i]=arr[i-1]+ran.nextInt(6)+1;
			arr[i]=ran.nextInt(200);
		}
		return  arr;
	}

}
