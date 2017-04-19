package lesson04;

interface X {
	
}

class A {
	void ma() {
		
	};
}

class B  extends A implements X{
	void mb() {
		
	};
}

class C extends B{
	void md() {
		
	};
}

public class TypeConversionApp {

	static void call (A a) {
		a.ma();
	}
	
	public static void main(String[] args) {
		C c = new C();
		A c1 = new C();
		call(c1);
		C z = (C) c1;

	}

}
