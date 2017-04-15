package org.VovaYa.lesson03;

public class ClassSample {

	
	int x;
	
	String name;
	
	public ClassSample(){
		
	}
public ClassSample(String name){
		System.out.println("constructor: name ="+ name + "this.name = "+ this.name);
		this.name = name;
	}
	
	public static void main(String[] args) {
		ClassSample p = new ClassSample();
		System.out.println(p.x);
		System.out.println(p.name);
	}
}
