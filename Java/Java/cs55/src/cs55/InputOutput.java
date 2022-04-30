package cs55;

// Sample of input/output program

//Unit of computation in Java is class. Every program start with public class ClassName

//and may have many methods. the main method is where program starts from.

//as a rule any name starts with Capital letter consider to be a class and we may create

//an object from. Example Scanner, we need to create object of Scanner to use its

//API. You can Google Scanner.java ans see all API on browser. you can and should

//Google for any class name.java, like String.java.

//the following shows some of Scanner API or method for I/O.
/*
My Name is :
My Major is : Computer Science


*/

import java.util.*;


public class InputOutput
{

public static void main(String [] args)
{ // code starts here
//lets create Scanner Object

Scanner input = new Scanner(System.in);
System.out.print("Enter an Integer:");
int num = input.nextInt();
System.out.println("you just entered "+num);
input.nextLine();
System.out.print("What is your name:");
String name = input.nextLine();
System.out.println(name + " you got nice name");

System.out.print("Enter Fraction number:");
float fNum = input.nextFloat();
System.out.println("you just entered "+fNum);

System.out.print("Enter Large Fraction number:");
double dNum = input.nextDouble();
System.out.println("you just entered "+dNum);



System.exit(0);
}



}
