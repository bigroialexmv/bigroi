package homeworks.homework02;

public class ArrayUtil {

	static int search (int[] a, int x) {
		BubbleArraySorter arraySorter = new BubbleArraySorter();
		arraySorter.sort(a);
		System.out.println(a);
		int p = 0;
		int q = a.length - 1;
		for (int i = (q - p)/2; i < a.length - 1; i = p + (q-p)/2) {
			if (a[i] == x) {
				return i;
		} else if (a[i] > x) {
			p = i;
		} else {
			q = i;
			}
	}
		return -1;
}
	
	public static void main(String[] args) {
		int [] a = {10, 9, 8};
		System.out.println(search(a, 10));
	}
}
 