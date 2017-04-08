package lesson03;

class Point {
	int x;
	int y;
	public Point (int x, int y){
		this.x =x;
		this.y =y;
	}
}

public class MethodSamples {
	
	int x = 10;
	static void method1() {
		System.out.println("method1");
	}
	
	static void changeX (int x, int y){
		x = 3;
		}
	
	static void changeX (int x){
		x = 3;
		}
	
	static void changePoint(Point p){
		p.x = p.x +3;
	}

	public static void main(String[] args) {
		MethodSamples.method1();
		int x = 5;
		changeX(x);
		System.out.println(x);
		
		Point p = new Point(10,10);
		changePoint(p);
		
		System.out.println("p.x = " + p.x);

		
	}

}
