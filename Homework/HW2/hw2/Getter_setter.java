package hw2;

import java.util.Iterator;
import java.util.Scanner;

public class Getter_setter {
	
	private int x;
	private int y;
	Scanner z;
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setZ() {
		System.out.println("Enter a string here:");
		z= new Scanner(System.in);
	
		z.next();
		
	}
	public String getZ() {
		return z.next();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static void main(String[] args) {
		//this is the tester class
		Getter_setter input= new Getter_setter();
		input.setZ();

	}
	

}
