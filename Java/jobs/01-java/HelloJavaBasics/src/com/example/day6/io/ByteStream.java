package com.example.day6.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStream {

	public static void main(String[] args) {
		String filename= "./ByteFile.txt";
		
		//readByteStream(filename);
		//writeByteStream(filename);
		readThisClassFile();
		
	}

	static void readByteStream(String filename) {
		InputStream inputs=null;
		try{
			int i;
			inputs = new FileInputStream(filename);
			
			while((i = inputs.read()) != -1) {
				System.out.println(i+" ");
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//one purpose of the finally block is to close resources/streams
			// so should be close the input stream?
			try {
				inputs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void writeByteStream(String filename) {
		/*
		 * try with resources automatically closes a resource when it is done
		 *   being used (after the try block).
		 * The try with resources uses a set of parenthesis after the "try" keyword
		 *   the parenthesis only accepts an object that is of type "AutoClosable"
		 *   or a descendant of AutoClosable
		 */
		try(FileOutputStream outs = new FileOutputStream(filename);) {
			System.out.println("beginning to write");
			outs.write(65);
			outs.write(66);
			outs.write(98);
			outs.write(200);
			outs.write(300);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readThisClassFile() {
		String filename = "./bin/com/example/day6/io/ByteStream.class";
		try(InputStream inputs= new FileInputStream(filename)){
			byte[] first4 = new byte[4];
			inputs.read(first4);
			
			for(byte b: first4) {
				System.out.print(Integer.toHexString(b).substring(6));
			}
			
 		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
