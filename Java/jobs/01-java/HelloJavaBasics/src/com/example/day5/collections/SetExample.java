package com.example.day5.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		//HASH SET
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(55);
		hashSet.add(60);
		hashSet.add(8);
		hashSet.add(7);
		hashSet.add(8);
		hashSet.add(14);
		hashSet.add(-99);
		hashSet.add(0);
		
		System.out.println(hashSet);
		System.out.println(hashSet.size());
		
		//TREE SET
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.addAll(hashSet);
		System.out.println(treeSet);
		
		hashSet.add(25);
		System.out.println(treeSet);
	}

}
