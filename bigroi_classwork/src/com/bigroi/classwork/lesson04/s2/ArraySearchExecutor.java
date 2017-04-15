package com.bigroi.classwork.lesson04.s2;

public class ArraySearchExecutor implements Executable {
	
	private ArraySearcher searcher;
	
	private int[] array;
	
	private int elem;

	public ArraySearchExecutor(ArraySearcher searcher, int[] array, int elem) {
		super();
		this.searcher = searcher;
		this.array = array;
		this.elem = elem;
	}

	@Override
	public void execute() {		
		searcher.search(array, elem);
	}
	
	@Override
	public String toString() {		
		return "Array Searcher Executor: " + searcher.getClass().getSimpleName();
	}

}
