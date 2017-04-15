package lesson04;

public class ArraySearcherApp {
	
	public static void print (int [] a) {
		
		for (int i = 0; i < a.length -1; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[a.length -1]);
	}

	public static void main(String[] args) {
		
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		print(a);
		
		ArraySearcher searcher1 = new LinearArraySearcher();
		System.out.println(searcher1.search(a, 10));
		TimeMeasurer timeMeasurer1 = new TimeMeasurer();
		long timePassed1 = timeMeasurer1.getPassedMillis();
		System.out.println("Время выполнения: " + timePassed1);
		
		ArraySearcher searcher = new BinaryArraySearcher();
		TimeMeasurer timeMeasurer = new TimeMeasurer();
		long timePassed = timeMeasurer.getPassedMillis();
		System.out.println("Время выполнения: " + timePassed);
		
		System.out.println(searcher.search(a, 10));
		System.out.println(searcher.search(a, 1));
		

	}

}
