package com.bigroi.classwork.lesson07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncMapSampleApp implements Runnable {
	
	Map<String, String> map;
	List<String> list;
	
	SyncMapSampleApp() {
		map = new HashMap<String, String>();
		list = Collections.synchronizedList( new ArrayList<String>());
		// map = Collections.synchronizedMap(map);
		//map = new ConcurrentHashMap<String, String>();
	}

	public static void main(String[] args) {
		
		SyncMapSampleApp appMap = new SyncMapSampleApp();
		
		Thread counterThread0 = new Thread(appMap);			
		Thread counterThread1 = new Thread(appMap);		
		counterThread0.start();
		counterThread1.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");
		for(int i=0; i< 10; i++) {
			map.put("key" + i, "value" + i);
			for(String v : map.values()) {
				System.out.println(Thread.currentThread().getName() + "" + v);
			}
			try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			list.add(""+i);
			map.remove("key" + (i-1));

		}		
	}

}
