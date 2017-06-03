package com.bigroi.classwork.lesson06;

public class StringSample {

	public static void main(String[] args) {
		
		String[] str = "vvv sss  dddd aaa".split(" ");		
		for(String s : str) {
			System.out.println(s);
		}
		System.out.println(str.length);
		
		System.out.println("******");
		String s = "vvv sss dddd aaa ";
		int c = 0;
		for(int i=0; i<s.length(); i++) {
			char a = s.charAt(i);
			if (a == ' ') {
				c++;
			}			
		}
		System.out.println(c);
		
		System.out.println("******");
		 s = "v vv   ";
		c = 0;
		for(int i=1; i<s.length(); i++) {
			char a = s.charAt(i);
			char b = s.charAt(i-1);
			if (a == ' ' && b != ' ') {
				c++;
			}			
		}
		System.out.println(c);
		
		
	}

}
