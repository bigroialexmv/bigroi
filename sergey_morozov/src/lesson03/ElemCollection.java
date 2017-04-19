package lesson03;

import java.util.Iterator;

public class ElemCollection implements Iterable<Integer> {

	Integer [] store = new Integer[10];
	int nextIndex = 0;
	
	public void add(Integer i) {
		store[nextIndex] = i;
		nextIndex++;
	}

	@Override
	public Iterator<Integer> iterator() {
		
		return new ElemIterator(this);
	} 
	
	class ElemIterator implements Iterator<Integer>{

		ElemCollection col;
		private int nextIndex;
		
		public ElemIterator(ElemCollection col) {
			
			this.col = col;
		}

		@Override
		public boolean hasNext() {
			if (this.nextIndex < col.nextIndex) {
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			nextIndex++;
			return col.nextIndex;
			
		}
		
	}
	
	public static void main(String[] args) {
		ElemCollection col = new ElemCollection();
		col.add(10);
		col.add(40);
		col.add(30);
		//for (Integer i : col) {
		//	if (i.hasNext()){
			//	System.out.println(i.next());
			//}
		//}
	}
}
