package com.example.day6.ioserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {

	public static void main(String[] args) {
		String filename = "./myBankingExample.txt";
		
		Person person = new Person("Carl", 26, "555-55-5555");
		
		//writeObject(filename, person);
		readObject(filename);
	}
	
	static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object obj = ois.readObject();// de-serialization
			System.out.println(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void writeObject(String filename, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(obj); // serialization

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
