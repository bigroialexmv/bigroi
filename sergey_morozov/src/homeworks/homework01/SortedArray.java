package homeworks.homework01;

public class SortedArray {

	static int isSorted (int[] a) {
		
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

	
	
	public static void print (int answer){
		if (answer == 1){
			System.out.println("The array is sorted in ascending order.");
		} else if (answer == -1) {
			System.out.println("The array is sorted in descending order.");
		} else 
			System.out.println("The array is not sorted.");
	}
	
	public static void main(String[] args) {
		
		int[] a1 = {2, 1, 0};
		int[] a2 = {-1, 0, 1, 2};
		int[] a3 = {0, -1, -1, 2};
		
		print (isSorted(a1));
		print(isSorted(a2));
		print (isSorted(a3));
		
	}
}