package org.alexkurets.lesson3.addObject;

import java.util.Iterator;



public class MyCollection implements Iterable<Integer> {

	private Integer [] store;
	
	public MyCollection(int a)
	{
		store=new Integer[a];
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new MyCollectionIterator();
	}
	
	
	private class MyCollectionIterator implements Iterator<Integer>
	{

		@Override
		public boolean hasNext() {
			
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
