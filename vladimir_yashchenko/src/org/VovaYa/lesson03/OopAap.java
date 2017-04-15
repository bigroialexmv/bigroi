package org.VovaYa.lesson03;


class PathX {
	
	protected Double distance;
	private double x0;
	private double x;
	
	public PathX() {
		}
	public PathX(double x0) {
		this.x0 = x0;
		
	}
	
	public double getDistance(){
		if(distance == null){
			distance =(x - x0);
		}
		 return distance;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	
	
	
}
class PathXY extends PathX {
	double y;

	public PathXY(double x, double y) {
		super(x);
		this.y = y;
	}
	
}

public class OopAap {

	public static void main(String[] args) {
		PathX pathX = new PathX(2);
		pathX.setX(10);
		System.out.println(pathX.getDistance());
		
		PathXY pathXY = new PathXY(2, 6);
		pathXY.setX(10);
		System.out.println(pathXY.getDistance());


	}

}
