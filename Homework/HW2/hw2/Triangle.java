package hw2;

/*
 * extends geometricObject
 * 
 * The class contains 
 * 1. 3 double data fields named side1... and so on
 * 2. no arg constructor that creates a default triangle
 * 3. a constructor that creates a triangle with a specified side
 * 4. Accessor methods for all the sides
 * 5. methods named getArea(). getPerimeter(), toString that returns a description
 * of the rectangle
 * 
 * test program: prompts the user to enter 3 sides of the triangle, color, and a Boolean 
 * value to indicate whether the triangle is filled. 
 * 
 * The program should create a Triangle object with these sides as set the color 
 * and filled properties using the input. The program should display the area, perimeter, 
 * color, and true or false to indicate whether it is filled or not.
 * 
 * What's common about both geometric object and Triangle: color
 */

/*
 * Notes for inheritance:
 * 
 * constructors: super(datafield)
 * method: super.methodname
 * 
 * ## use the keyword: extends to inherit from another class and super is used to access the methods in
 * the parent class
 */
import java.util.Scanner;
import java.lang.Math;

public class Triangle {
	double side1;
	double side2;
	double side3;
	
	double sides;
	double tri;
	double tri1;
	
	
	Triangle(){
		
	}
	
	public void getSides() { //getters for the double data fields
		System.out.println("Enter a number for side a: ");
		Scanner first= new Scanner(System.in);
		this.side1= first.nextDouble();
		
		
		System.out.println("Enter a number for side b: ");
		Scanner sec= new Scanner(System.in);
		this.side2= sec.nextDouble();
		
		
		System.out.println("Enter a number for side c: ");
		Scanner third= new Scanner(System.in);
		this.side3= third.nextDouble();
	
		}
	public double getArea() {
		double sides= (side1+side2+side3) /2;
		if (side1<sides && side2 <sides && side3 <sides) {
			tri1= Math.sqrt(sides*((sides-side1)*(sides-side2)*(sides-side3)));
		}
		return tri1;
		
	}
	public double periTriangle() {
		tri= side1+side2+side3;
		return tri;
	}
	public String toString() {
		return "The area of the triangle is: "+ tri +  "\n"+ "The perimeter is: "+ tri1;
	}
	

	public static void main(String[] args) {
		Triangle angle1= new Triangle();
		angle1.getSides();
		angle1.periTriangle();
		angle1.getArea();
		System.out.println(angle1.toString());
	}

}
