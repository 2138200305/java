package com.example.day5.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListExample {

	public static void main(String[] args) {
		// ARRAYLIST

		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(5);
		arrayList.add(5);
		arrayList.add(7);
		arrayList.add(12);
		arrayList.add(8);
		arrayList.add(4);
		arrayList.add(22);

		System.out.println(arrayList); // the arraylist has a toString() method
		System.out.println(arrayList.get(2));
		//System.out.println(arrayList.get(20));

		
		//LINKED LIST
		List<Integer> linkedList = new LinkedList<>();
		//it's used the same exact way as arraylist
		//DONE.....
		
		
		
		
		
		
		// Iterators
		ListIterator<Integer> listIterator = arrayList.listIterator();

		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}

		ListIterator<Integer> listIteratorTwo = arrayList.listIterator(arrayList.size());

		while (listIteratorTwo.hasPrevious()) {
			System.out.print(listIteratorTwo.previous() + " ");
		}
	}

}
