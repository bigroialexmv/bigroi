package lesson03;

class PathX {
	
	protected Double distance;
	private double x0;
	private double x;
	
	
	public PathX() {
		
	}


	public PathX(double x0) {
		this.x0 = x0;
	}


	public PathX(double x0, double x) {
		
		this.x0 = x0;
		this.x = x;
	}
	
	public double getDistance() {
		if (distance == null){
			return (x - x0);
	}
		return distance;
	}

	protected double sub(double a, double b){
		return (a-b);
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
	double y0;

	public PathXY(double x,double y) {
		super(x);
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public double getDistance(){
		double dX = super.getDistance();
		double dY = sub(y,y0);
		return Math.sqrt(Math.pow(dX, dY) + Math.pow(dY, dY));
	}
	
}

public class OopApp {

	public static void main(String[] args) {
		PathX pathX = new PathX (2);
		pathX.setX(10);
		System.out.println(pathX.getDistance());
		
		PathXY pathXY = new PathXY (0,3);
		pathXY.setX(10);
		System.out.println(pathX.getDistance());
		
		PathX px = pathXY;

	}

}
