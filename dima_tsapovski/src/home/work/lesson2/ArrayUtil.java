package home.work.lesson2;



public class ArrayUtil {

	public static void main(String[] args) {
		
		
		
	 int b = abraCadabra ();
		System.out.println(b);
	}
		public static int abraCadabra (){
		  int[] massiv = new int [14];
	        int even = 0;
	        int odd = 0;
	        for (int i = 0; i < 14; i++) {
	        	massiv[i]=i;	        	
				if (massiv[i] % 2 == 0) {
					even = even + massiv[i];
					
	            } else {	            	
	                odd = odd + massiv[i];	              
      
	        }			
	    }
			return even - odd;
	}
}
	           
		


