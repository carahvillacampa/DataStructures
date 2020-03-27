package hw2;
import java.util.Scanner;

public class GeometricObject {
	String color;
	
	GeometricObject(){
		
	}
	
	public String objColor() {
		System.out.println("Enter a color for your object: ");
		Scanner object1= new Scanner(System.in);
		this.color= object1.next();
		return color;
	}

	public static void main(String[] args) {
		GeometricObject obj1= new GeometricObject();
		
	}

}
