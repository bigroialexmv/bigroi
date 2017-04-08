package org.alexkurets.lesson3;

import org.alexkurets.lesson3.addObject.Point;

public class Application3 {
	public static void change(Point x){
		x.x+=3;
	}
	
	public static void main(String[] args) {
		
		Point p = new Point(10,10);
		change(p);//objects go to method by reference
		System.out.println(p.x);
		
	}

}
