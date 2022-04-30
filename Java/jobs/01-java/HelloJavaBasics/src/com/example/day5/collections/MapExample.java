package com.example.day5.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapExample {

	public static void main(String[] args) {
		//HASH MAP
		
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(44, "Ngozi");
		hashMap.put(22, "David");
		hashMap.put(7, "Colton");
		hashMap.put(9, "Kevin");
		hashMap.put(9, "La'Keyera"); //overrides
		//hashMap.put(null, "Andrew");
		
		/*System.out.println(hashMap);
		System.out.println(hashMap.size());
		System.out.println(hashMap.get(7));
		System.out.println(hashMap.get(99));*/
		
		
		//Loop
		//You can iterate over...the key set, the value set,or the entry set(both)
		for(Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+ "\t"+entry.getValue());
			//this is an example of iterating over the entry set
			//   later, try to iterate over one or the other
		}
		
		
		//TREEMAP
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.putAll(hashMap);
		
		System.out.println("\nTreeMap Loop: ");
		for(Entry<Integer, String> entry: treeMap.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
	}

}
