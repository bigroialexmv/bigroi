package org.alexkurets.lesson3;

import org.alexkurets.lesson3.addObject.PathX;
import org.alexkurets.lesson3.addObject.PathXY;

public class Application4 {
	
	public static void main(String[] args) {
		PathX pathX1 = new PathX(0,0);
		pathX1.setPoint(10);
		
		System.out.println(pathX1.getDistance());
		
		PathXY pathXY1 = new PathXY(0, 2, 0, 5);
		PathX temp = pathXY1;
		
		System.out.println(temp.getDistance());
		pathXY1.tempMethod();
		
		
	}

}
