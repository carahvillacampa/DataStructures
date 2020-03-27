package hw2;
/*
 * Design a class named rectangle. The class will contain:
 * 1. Two double data fields named width and height with default values of one
 * 2. no ag constructor creates a default rectangle
 * 3. a constructor that creates a rectangle with the specified width and height
 * 4. method named getArea() that returns the area of the rectangle
 * 5.method named getPerimeter() that returns the perimeter.
 * 
 * Test program:
 * 1. create two rectangle objects: one width- 4; height-40 
 * 2. other width- 3.5; other height- 35.9
 * 3. display the width, height, perimeter for each rectangle in this order
 */
public class Rectangle {
	public double height=1;
	public double width=1;
	
	
	Rectangle() {
	}
	
	Rectangle(double h, double w) {
		this.height= h;
		this.width= w;
	}
	public double getArea() {
		return height*width;
	}
	
	public double getPeri() {
		return 2*(height+width);
	}
	public static void main(String[] args) {
		Rectangle rec1= new Rectangle(4,40);
		System.out.println("The area of rec1 is: "+rec1.getArea());
		System.out.println("The perimeter of rec1 is: "+ rec1.getPeri());
		Rectangle rec2= new Rectangle(3.5,35.9);
		System.out.println("The area of rec2 is: "+ rec2.getArea());
		System.out.println("The perimeter of rec2 is: "+ rec2.getPeri());

	}

}
