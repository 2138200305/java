package com.example.day5.sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {
	String s;
	static int i;
	{
		s= "hello";
	}
	static {
		i=15;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("stuff");
		list.add("pop, not soda");
		list.add("Walmart");
		list.add("amazon is better");
		list.add("hippo");
		
		System.out.println(list);
		/*CollectionSSSSSSS <---note the "s"
		 *   is a utility class filled with static method that aid with objects
		 *   	that are of the Collection type.
		 */
		Collections.sort(list);
		System.out.println(list);
		
		//////////////CUSTOM CLASSES
		
		List<Student> myStudentList = new ArrayList<>();
		myStudentList.add(new Student(3, "John", 3.5, LocalDate.of(1970, 2, 12)));
		myStudentList.add(new Student(17, "Amy", 3.1, LocalDate.of(1989, 1, 15)));
		myStudentList.add(new Student(1, "Austin", 4.0, LocalDate.of(1971, 3, 30)));
		myStudentList.add(new Student(2, "Katie", 2.9, LocalDate.of(1776, 12, 02)));
		myStudentList.add(new Student(4, "Courtney", 3.0, LocalDate.of(1004, 7, 12)));
		
		//the comparable interface defines the NATURAL (common) ordering
		//  of an object
		printListPretty(myStudentList);
		
		Collections.sort(myStudentList);
		System.out.println("natural ordering: ");
		printListPretty(myStudentList);
		
		//but....what if I want to sort it in an UNNATURAL (aka uncommon) way?
		Collections.sort(myStudentList, new StudentGpaComparator());
		System.out.println("unnatural ordering: ");
		printListPretty(myStudentList);
		
		/*
		 * Comparator is the unnatural ordering. You have to specifically tell
		 * a sorting method (or treeset/map) to use it. If you don't specify
		 * then the sorting algorithm will use the natural ordering instead.
		 * 
		 * to make it easier on yourself...the natural ordering should be declared
		 * as the most COMMON usage for your sorting necessities.
		 * 
		 * You have as many unnatural ordering comparators defined as you like.
		 * 
		 * Try to create a comparator for DoB and Name of the students
		 */
	}
	
	static void printListPretty(List<Student> list) {
		System.out.println("Students: ");
		for(Student stud: list) {
			System.out.println(" "+stud);
		}
		System.out.println();
	}

}
