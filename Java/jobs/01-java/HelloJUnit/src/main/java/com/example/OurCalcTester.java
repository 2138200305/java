package com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//this way to import is no longer supported
//import junit.framework.Assert;

//@FixMethodOrder
public class OurCalcTester {

	static Calculator ourCalc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ourCalc= new Calculator();
		System.out.println("----------BEFORE CLASS----------");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("----------AFTER CLASS----------");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("----------before method----------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("----------after method----------");
	}

	@Test
	public void multiplyTest() {
		//fail("Not yet implemented");
		System.out.println("in multiply test");
		assertEquals("this is 2x5 test",10, ourCalc.multiply(2, 5));
		assertEquals("this is 5x2 test",10, ourCalc.multiply(5, 2));
		assertEquals("this is 5x5 test",25, ourCalc.multiply(5, 5));
	}
	
	@Test
	public void addTest() {
		//fail("Not yet implemented");
		System.out.println("in add test");
		assertEquals("this is  test",7, ourCalc.add(2, 5));
		assertEquals("this is  test",100, ourCalc.add(5, 95));
		assertEquals("this is  test",25, ourCalc.add(5, 20));
	}
	
	@Ignore()
	@Test(timeout=3000)
	public void timeTest() {
		System.out.println("inside time test");
		ourCalc.timeMethod();
	}

	@Test(expected=IllegalArgumentException.class)
	public void xyzTest() {
		System.out.println("inside xyz method");
		ourCalc.xyzMethod();
	}
}
