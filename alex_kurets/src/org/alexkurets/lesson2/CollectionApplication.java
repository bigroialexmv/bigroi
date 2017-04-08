package org.alexkurets.lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionApplication {

	public static void main(String[] args) {
		
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		
		
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		
		Map<String, String> map=new HashMap<>();
		
		map.put("iteration", "��������");
		map.put("collection", "���������");
		map.put("map", "�����");
		map.put("map", "���������");
		
		
		System.out.println(map.get("map"));
		
		
		
	}

}
