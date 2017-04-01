package org.alexkurets.lesson2;


public class Application1 {

	public static void main(String[] args) {
		int x=2;
		int y=3;
		
		
		Person pers1=null;
		
		print(x, y);
		System.out.println("Swap of variables");
		y=x;
		print(x,y);
		
		//Integer xx=new Integer(2);//2
		//Integer yy=new Integer(3);//3
		Integer xx= 2;//2
		Integer yy= 3;//3
		
		print(xx,yy);
		System.out.println("Swap of objects");
		xx=yy;
		print(xx,yy);
		xx=5;
		print(xx,yy);
		
		
	}

	private static void print(int x, int y) {
		System.out.println("x= "+x+", "+"y= "+y);
	}

}
