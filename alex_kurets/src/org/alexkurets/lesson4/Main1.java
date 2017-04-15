package org.alexkurets.lesson4;

public class Main1 {
	public static void main(String [] args)
	{
		User user1 = new User("Oliver",30);
		System.out.println("user: "+user1);
		
		
		User user2=new User("0liver",30);
		
		System.out.println(user1.equals(user2));
		;

	}
}
