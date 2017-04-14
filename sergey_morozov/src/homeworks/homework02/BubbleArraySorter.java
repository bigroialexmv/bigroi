package homeworks.homework02;

public class BubbleArraySorter implements ArraySorter {

	@Override
	public void sort(int[] a) {
		
		for (int i = 0; i < a.length - 1; i++) {
			for (int k = 0; k < a.length - i - 1; k++) {
				if (a[k] > a[k + 1]) {
					int holder = a[k];
					a[k] = a[k + 1];
					a[k + 1] = holder;
				}
			}
		}
	}
}
		
