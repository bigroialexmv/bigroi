package org.VovaYa.lesson02;

class ArrayUtil {
	static void swap(int[] a, int i, int j){
		int x = a[i];
		a[i] = a[j];
		a[j]= x;
	}
	
	static int max(int[] a){
		int m =0;
		for(int i=0; i < a.length; i++){
			if (m < a[i]){
				m=a[i];
			}
		}
		return m;
	}
		
	static int search(int [] a, int  x){
		int  i = 0;
		for(int k = 0; k < a.length; k ++)
			if (x == a[k]){
				i=k;
				break;
			}
		return i;
	}
	
	
	
	static void print(int[] a){
		for(int i=0; i < a.length; i++){
			System.out.print( a[i] );
			System.out.print( " " );
		}
		System.out.println();
	}

    static int searchB(int [] a, int x){
    	int index = 0;
    	int i = a.length / 2;
    	int p = 0;
    	int q= a.length;
    	if ( x < a[i]){
    		
    	} else if ( x > a[i]){
    		
    	}
    	return index;
    }
	
	

}

public class ArrayApplication {
	public static void main(String[] args) {
		int [] a = new int[] {34, 45, 6, 32, 23, 81, 56};
		ArrayUtil.print(a);
		ArrayUtil.swap(a, 0, a.length -1);
		ArrayUtil.print(a);
		ArrayUtil.print(a);
		int max = ArrayUtil.max(a);
		System.out.println("max = " + max);
		int index = ArrayUtil.search(a, 23);
		System.out.println("index = " + index);

	}
}
