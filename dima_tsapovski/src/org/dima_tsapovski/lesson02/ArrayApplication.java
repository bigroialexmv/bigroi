package org.dima_tsapovski.lesson02;


class ArrayUtil{
	
	 static void swap(int[] a, int i, int j){
		int x = a[i]; 
		 a[i] = a[j];
		 a[j] = x;
}
	 static int max(int[] a){
			int m = a[0];
			for (int i = 0; i < a.length; i++ ){
				if (m<a[i]){
					m = a[i];
				}
			}
			 return m;
	}
	 static int search (int[] a, int x){
			int i = a[0];
			for (int k = 0; k < a.length; k++ ){
				if (x ==a[k]){
				i=k;
				break;
				}
}
			return i;
	 }

	 static void ptint(int[]a){
		 
		 for (int i = 0; i < a.length; i++ ){
			 
			 System.out.print(a[i]);
			 System.out.print(" ");
		 }
		 System.out.println();
	 }
	 static int searchB(int[]a, int x){
		 int index =0;
		 int i = a.length /2;
		 int p = 0;
		 int q = a.length;
		 if (x < a[i]){
			 
		 }else if (x>a[i]){
			 
		 }
		 return index;
	 }
}
public class ArrayApplication {
	
	
	public static void main(String[] args) {
		int[] a = new int [] {34, 45, 6, 34, 23, 44, 56};
		ArrayUtil.ptint(a);
		ArrayUtil.swap(a, 0, a.length -1);
 int max = ArrayUtil.max(a);
 
 
	}

}
