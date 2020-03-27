package hw2;
 /*
  * Create a program that allows users to enter an array
  * and analyzes :
  * 1.the average of the array 
  * 2. the lowest number in the array
  * 
  * Pseudocode:
  * 1. create an array
  * 2. prompt the user to enter numbers for the array
  * 3. method to analyze the average of the array the user entered //make counter
  * 4. method to calculate the lowest number based on that array //make counter
  * 5. prints the results
  * 
  */
import java.util.Scanner;
public class Analyze {
	int [] array1= new int [5]; //declare the array
	int arr;
	int ave;
	int low;
	int max;
	
	Analyze(){
		
	}
	public void userIn() {
		System.out.println("Enter "+array1.length+" numbers: ");
		Scanner user1= new Scanner(System.in);
		
		for (int i=0; i < array1.length; i++) {
			this.array1[i]= user1.nextInt();
		}
		
		user1.close();
	}
	
	public int averageNum() { //calculates the sum of the array
		System.out.println("Average value: ");
		this.arr=0; // stands as a counter
		for (int i=0; i <array1.length; i++) { //variable on top should be the same as variable on the bottom
			arr +=array1[i];
			this.ave= arr/array1.length;
		}
		return ave;
	}
	public int lowestNum() {
		System.out.println("The lowest number in the array: ");
		this.max=0;
		for (int y=0; y < array1.length; y++) {
			if (array1[y] > max) max+= array1[y];
		}
		this.low=0;
		for (int i=0; i < array1.length; i++) {
			if (array1[i] < max) low= array1[i];
		}
		return low;
	}
	
	
	
	public static void main(String[] args) {
		Analyze student1= new Analyze();
		student1.userIn();
		System.out.println(student1.averageNum());
		System.out.println(student1.lowestNum());
		

	}
	

}
