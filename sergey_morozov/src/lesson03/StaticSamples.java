package lesson03;

public class StaticSamples {
	
	public static final String STATIC_CONST = "A1";
	public static final double PI = Math.PI;
	
	static {
		System.out.println("1");
	}
	
	public StaticSamples() {
		System.out.println("Constructor");
	}

	public static void main(String[] args) {
		
		StaticSamples o1 = new StaticSamples();
		StaticSamples o2 = new StaticSamples();
		
		//StaticSamples.STATIC_CONST = "B";
		System.out.println(StaticSamples.STATIC_CONST);
		System.out.println(StaticSamples.STATIC_CONST);

	}

}
