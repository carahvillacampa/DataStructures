package hw2;

public class method_overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add(3,4); //calling the method in the main method
		System.out.println("integers "+Add(3,4)); //printing the result in the main method
		Add(5.6,57.0);
		System.out.println("double "+ Add(5.6,57.0));
		Add("fuck", "you");
		System.out.println(Add("Michael", "Scott"));
		subtract(2,3);
		System.out.println(subtract(2,3));

	}
	public static int Add(int x, int y) { //instead of void, int is used as a data return type: has 2 parameters: x and y
		return (x+y);					  // returns the sum of x and y
	}
	public static double Add(double x, double y) {
		return (x+y);
	}
	public static String Add(String x, String y) {
		return("The concantenation of x and y is "+ x+" "+ y);
	}
	public static int subtract(int x, int y) {
		return x-y;
	}
	

}
