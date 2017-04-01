package com.bigroi.classwork.lesson02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CollectionsApllication {

	public static void main(String[] args) {
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		
		System.out.println( a.get(1) );
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("iteration", "итерация");
		map.put("collection", "коллекция");
		map.put("cycle", "цикл");
		map.put("cycle2", "цикл");
		
		System.out.println( map.get("iteration")  );
		
		if ( map.containsKey("iteration") ) {
			System.out.println (map.get("iteration"));
		} else {
			System.out.println ("Слово не найдено");
		}
		
		Stack<String> stack = new Stack<String>();
		stack.push("a1");
		stack.push("a2");
		stack.push("a3");
		
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		
		
		
	}

}
