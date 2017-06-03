package homeworks.homework02;

public class ArrayUtil {

	static int search (int[] a, int x) {
		
		
		int p = 0;
		int q = a.length - 1;
		if (a[0] == x) return 0;
		if (a[q] == x) return q;
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
}
	
 