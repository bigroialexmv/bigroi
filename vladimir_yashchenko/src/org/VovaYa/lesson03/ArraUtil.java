package org.VovaYa.lesson03;

import java.awt.print.Printable;

public class ArraUtil {

	public static void print(int [] a){
		for (int i = 0; i < a.length; i++){
			System.out.print(a [i]);
			System.out.print(" ");
		}
	}
	
	public static int isSorted(int[] a){
		int sortedUp = 1;
		int sortedDown =-1;
		for (int i = 1; i < a.length; i++){
			if (!(a[i-1]<= a[i])){
				sortedUp = 0;
			}
			if (!(a[i-1]>= a[i])){
				sortedDown = 0;
			}
			if (sortedUp == 1){
				return 1;
			}
			if (sortedDown == -1){
				return -1;
			}
		}
				
		return 0;
	}
	
	public static void main(String[] args) {
		int [] a = new int [] {3,5,7,8};
		
		print(a);
		System.out.println();
		System.out.println(isSorted(a));

	}

}
