package lesson03;

public class ClassSample {
	
	int x;
	
	String name;
	
	final String finalName;
	
	public ClassSample() {
		finalName = "final value";
				
	}
	
public ClassSample(String name) {
		this();
		System.out.println("Constructor: name = " + name + ", this.name = " + this.name);
		this.name = name;
	}

public ClassSample(int x) {
	this();
	System.out.println("Constructor: name = " + name + ", this.name = " + this.name);
	this.x = x;
}

public ClassSample(String name, int x) {
	this();
	System.out.println("Constructor: name = " + name + ", this.name = " + this.name);
	this.name = name;
	this.x = x;
}
	
	public static void main(String[] args) {
		
		ClassSample p = new ClassSample();
		
		System.out.println(p.x);
		System.out.println(p.name);
		
		ClassSample p1 = new ClassSample ("Name 1");
		System.out.println(p1.x);
		System.out.println(p1.name);
	}
}
