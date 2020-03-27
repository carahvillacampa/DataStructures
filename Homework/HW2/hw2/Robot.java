package hw2;

public class Robot { //instance levels
	String name;
	String color;
	int weight;
	Robot lookingAt;
	
	public Robot (String n, String c, int w) { //constructor: access to everyone in the class  
		this.name= n;
		this.color= c;
		this.weight= w;
	}
	
	void introduceSelf() { //method with no parameters
						   // just prints the stuff
		System.out.println("My name is "+ name + "\n"+"My color is "+ color);
	}
	void lookingAt() {
		System.out.println(this.name +"is looking at "+ name);
	}
	public static void main(String [] args) { //applies to all objects in the class
		/**
		 * tester code
		 * 
		 * Definitions of stuff:
		 * 1. static is only accessible through the class:
		 * 2. 
		 */
		
		
		Robot r1= new Robot("Pooch","black",100);
		r1.introduceSelf();
		Robot r2= new Robot("Bean","white", 60);
		r2.introduceSelf();
		r1.lookingAt= r2;
	}
	

}
