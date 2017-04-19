package homeworks.homework01;

public class Coins {

	static int getValue (int a, int b){
		if (a < b)
			return 1;
		else if (a > b)
			return -1;
		else
			return 0;
	}
	
			
		public static void main (String [] args) throws ArrayIndexOutOfBoundsException{
	
		
		int [] coins = new int []{9,10,10,10,10,10,10,10,10,9};
		
		for (int i = 0; i < coins.length-1; i++) {
			if (getValue(coins[i],coins[i+1]) == 1)
				System.out.println("Coin No. " + (i+1) + " is smaller than others.");
			else if (getValue(coins[i],coins[i+1]) == -1)
				System.out.println("Coin No. " + (i+2) + " is smaller than others.");
		}
	}
	}
