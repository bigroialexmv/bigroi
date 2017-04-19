package homeworks.homework03;

import homeworks.homework02.ArraySorter;

public class SortExecutor implements Executable {

	private ArraySorter sorter;
	private int[] array;
	
	public SortExecutor (ArraySorter sorter, int[] array) {
		this.sorter = sorter;
		this.array = array;
	}
	
	@Override
	public void execute() {
		sorter.sort(array);

	}

}
