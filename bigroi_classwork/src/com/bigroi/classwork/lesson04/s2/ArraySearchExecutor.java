package com.bigroi.classwork.lesson04.s2;

public class ArraySearchExecutor implements Executable {
	
	private ArraySearcher searcher;
	
	private int[] array;
	
	private Integer elem;
	
	public ArraySearchExecutor(ArraySearcher searcher, int[] array) {
		super();
		this.searcher = searcher;
		this.array = array;		
	}

	public ArraySearchExecutor(ArraySearcher searcher, int[] array, int elem) {
		super();
		this.searcher = searcher;
		this.array = array;
		this.elem = elem;
	}

	@Override
	public void execute() {
		int e = 0;
		if (elem == null) {
			e = (int) (Math.random() * 10000);
		} else {
			e = elem;
		}
		searcher.search(array, e);
	}
	
	@Override
	public String toString() {		
		return "Array Searcher Executor: " + searcher.getClass().getSimpleName();
	}

}
