package com.example.day6.reflectionapi;

import com.example.day6.object.DummyObject;

/*
 * Reflection allows one to view an object or primitive during runtime
 * 	you may also modify the object's structure during runtime
 */
public class ReflectionExample {

	public static void main(String[] args) {
		DummyObject dum = new DummyObject();

		Class reflect = dum.getClass();
		
		System.out.println(reflect.getName());
		System.out.println(reflect.isPrimitive());
		System.out.println(reflect.getSuperclass());
		System.out.println(reflect.getModifiers());
		//reflect.
		
		System.out.println(dum instanceof DummyObject);
	}

}
