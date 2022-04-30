package com.example.day6.ioserialization;

import java.io.Serializable;

public class Person implements Serializable {
	
	//this variable is used as a way to identify the object itself
	//   we want to make sure the object that wrote to the file is the same
	//	 as the object you're attempting to read it in as.
	private static final long serialVersionUID = 2L;
	
	private String name;
	private int age;
	private transient String ssn;
	
	public Person() {
	}

	public Person(String name, int age, String ssn) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Person \n\t[name=" + name + ", age=" + age + ", ssn=" + ssn + "]";
	}
	
	
}
